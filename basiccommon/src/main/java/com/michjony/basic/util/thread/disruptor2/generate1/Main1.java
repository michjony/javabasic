package com.michjony.basic.util.thread.disruptor2.generate1;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

import java.util.concurrent.*;

/**
 * user:Cherie
 * datetime;2019/7/7 15:22
 */
public class Main1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;
        final RingBuffer<TradeData> ringBuffer = RingBuffer.createSingleProducer(new TradeFactory(), BUFFER_SIZE, new YieldingWaitStrategy());
        // 线程池
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_NUMBERS);

        // 序列的障碍
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器，本质是事件处理器
        BatchEventProcessor<TradeData> transProcessor = new BatchEventProcessor<>(ringBuffer, sequenceBarrier, new TradeDataHandler());

        //这一步的目的就是把消费者的位置信息引用注入到生产者    如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(transProcessor.getSequence());

        //把消息处理器提交到线程池
        executors.submit(transProcessor);

        Future<?> future = executors.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                long seq;
                for (int i = 0; i < 100; i++) {
                    seq = ringBuffer.next();
                    TradeData tradeData = ringBuffer.get(seq);
                    tradeData.setPrice(Math.random() * 9999);
                    ringBuffer.publish(seq);
                }
                return null;
            }
        });

        future.get();//等待生产者结束
        Thread.sleep(1000);//等上1秒，等消费都处理完成
        transProcessor.halt();//通知事件(或者说消息)处理器 可以结束了（并不是马上结束!!!）
        executors.shutdown();//终止线程

    }
}
