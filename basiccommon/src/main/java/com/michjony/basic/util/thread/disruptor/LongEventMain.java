package com.michjony.basic.util.thread.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class LongEventMain {
	
	public static void main(String[] args) throws InterruptedException {
		//创建缓冲池
		ExecutorService executor = Executors.newCachedThreadPool();
		ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
		//创建工厂
		LongEventFactory factory = new LongEventFactory();
		//创建buffersize  就是 RingBuffer的大小   必须为2的N次方
		int ringBufferSize = 1024 * 1024 ;
		//创建disruptor
		Disruptor<LongEvent> disruptor = 
						new Disruptor<LongEvent>(factory, ringBufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());
				// 连接消费事件方法
		disruptor.handleEventsWith(new LongEventHandler());
		
//		Disruptor<LongEvent> disruptorA = new Disruptor<LongEvent>(factory,
//				ringBufferSize,defaultThreadFactory,
//				ProducerType.SINGLE, //生产者内省
//				new YieldingWaitStrategy()); //CPU策略  BlockingWaitStrategy  SleepingWaitStrategy 
		
		//启动
		disruptor.start();
		//disruptor的事件发布过程是一个两阶段提交的过程
		//发布事件
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		
		//分配一个字节缓冲区  
		ByteBuffer bb = ByteBuffer.allocate(8);
		for (long i = 0 ; i < 100; i ++) {
			bb.putLong(0,i);
			producer.onData(bb);
			//TimeUnit.SECONDS.sleep(1);
			bb.clear();
		}
		
		disruptor.shutdown();
		executor.shutdown();
	}
	

}
