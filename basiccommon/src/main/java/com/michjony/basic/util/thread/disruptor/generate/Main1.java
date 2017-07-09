package com.michjony.basic.util.thread.disruptor.generate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class Main1 {
	
	public static void main(String[] args) {
		int BUFFER_SIZE = 1024;
		int THREAD_NUMBERS = 4 ;
		
		//创建单生产者的RingBuffer  事件工厂 , RingBuffer大小  , 等待策略
		final RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Trade>() {
			@Override
			public Trade newInstance() {
				return new Trade();
			}

		}, BUFFER_SIZE, new YieldingWaitStrategy());
		//线程池
		ExecutorService es = Executors.newFixedThreadPool(THREAD_NUMBERS);
		//创建SequenceBarrier 序列障碍  
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier() ;
		//创建消息处理器
		BatchEventProcessor<Trade> tProcessor = new BatchEventProcessor<Trade>(
				ringBuffer, sequenceBarrier, new TradeHandler());
		
		ringBuffer.addGatingSequences(tProcessor.getSequence());
		
		es.submit(tProcessor);
		
		Future<Void> future = es.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				long seq;
				for (int i = 0; i < 10; i++) {
					seq = ringBuffer.next();
					ringBuffer.get(seq).setPrice(Math.random()*9999);
					ringBuffer.publish(seq);
				}
				return null;
			}
			
		});
		
		try {
			// 阻塞 等待生产者结束
			future.get();
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通知事件处理器  可以结束了
		tProcessor.halt();
		//终止线程
		es.shutdown();
	}
}
