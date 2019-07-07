package com.michjony.basic.util.thread.disruptor2.generate1;

import com.lmax.disruptor.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * user:Cherie
 * datetime;2019/7/7 16:06
 */
public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        int BUFFER_SIZE = 1024;
        int THREAD_NUMBERS = 4;
        final RingBuffer<TradeData> ringBuffer = RingBuffer.createSingleProducer(new TradeFactory(), BUFFER_SIZE, new YieldingWaitStrategy());
        // 序列的障碍
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        // 线程池
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_NUMBERS);

        WorkHandler<TradeData> handler = new TradeDataHandler();

        WorkerPool<TradeData> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), handler);

        workerPool.start(executors);

        for (int i = 0; i < 100; i++) {
            long seq = ringBuffer.next();
            TradeData tradeData = ringBuffer.get(seq);
            tradeData.setPrice(Math.random() * 9999);
            ringBuffer.publish(seq);
        }

        System.out.println("123");
        workerPool.halt();
        executors.shutdown();
    }

}
