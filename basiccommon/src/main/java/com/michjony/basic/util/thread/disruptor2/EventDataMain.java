package com.michjony.basic.util.thread.disruptor2;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventDataMain {

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        // 创建缓冲此
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建工厂
        EventDataFactory factory = new EventDataFactory();
        // 创建buffersize，就是ringbuffer大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024;
        /**
         //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
         WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
         //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
         WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
         //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
         WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
         */

        //创建disruptor实例，指定数据类型
        // 1.工厂类对象，用于创建一个个的EventData数据，这个是实际的消费数据
        // 2.第二个参数是缓冲区大小
        // 3.线程池，disruptor使用这个线程池进行disruptor 内部的数据接收处理调度
        // 4.ProducerType.SINGLE (单一生产者)和 ProducerType.MULTI (多个生产者)
        // 5.第五个参数是一种策略，Strategy 策略
        Disruptor<EventData> disruptor =
                new Disruptor<EventData>(factory, ringBufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());
        // 连接消费事件方法 ， EventDataHandler 是一个消费者
        disruptor.handleEventsWith(new EventDataHandler());
        disruptor.start();

        // Disruptor 的事件发布过程是一个两阶段提交的过程
        //  发布事件 使用该方法获取具体容器
        RingBuffer<EventData> ringBuffer = disruptor.getRingBuffer();

//        EventDataProducer producer = new EventDataProducer(ringBuffer);

        EventDataProducerWithTranslator producer = new EventDataProducerWithTranslator(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long i = 0; i < 100000; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }

        disruptor.shutdown();
        executor.shutdown();
        System.out.println((System.currentTimeMillis() - starttime)  + "ms");

    }
}
