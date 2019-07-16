package com.michjony.basic.util.thread.disruptor2.mult;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * user:Cherie
 * datetime;2019/7/7 22:24
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        // 创建 ringBuffer
        RingBuffer<Order> ringBuffer = RingBuffer.create(ProducerType.MULTI, new EventFactory<Order>() {
            @Override
            public Order newInstance() {
                return new Order();
            }
        }, 1024 * 2, new YieldingWaitStrategy());

        SequenceBarrier barrier = ringBuffer.newBarrier();
        Consumer[] consumers = new Consumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("c" + i);
        }

        // 三个消费者
        WorkerPool<Order> workerPool =
                new WorkerPool<Order>(ringBuffer,
                        barrier,
                        new IntEventExceptionHandler(),
                        consumers);

        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            final Producer p = new Producer(ringBuffer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        p.onData(UUID.randomUUID().toString());
                    }
                }
            }).start();
        }
        System.out.println("---------------开始生产-----------------");
        latch.countDown();
        System.out.println("总数:" + consumers[0].getCount());
        for (int i = 0; ; i++) {
            System.out.println("i :" + i + "总数:" + consumers[0].getCount());
            if (consumers[0].getCount() == 10000) {
                System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
                System.exit(0);
            } else {
                TimeUnit.MICROSECONDS.sleep(1000);
            }
        }
    }

    static class IntEventExceptionHandler implements ExceptionHandler {
        @Override
        public void handleEventException(Throwable ex, long sequence, Object event) {
        }

        @Override
        public void handleOnStartException(Throwable ex) {
        }

        @Override
        public void handleOnShutdownException(Throwable ex) {
        }
    }
}
