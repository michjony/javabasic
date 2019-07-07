package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * user:Cherie
 * datetime;2019/7/7 16:42
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        long beginTime = System.currentTimeMillis();
        int bufferSize = 1024;
        ExecutorService executors = Executors.newFixedThreadPool(8);

        Disruptor<TradeData> disruptor = new Disruptor<TradeData>(new EventFactory<TradeData>() {
            @Override
            public TradeData newInstance() {
                return new TradeData();
            }
        }, bufferSize, executors, ProducerType.SINGLE, new BusySpinWaitStrategy());

        // 棱形操作 ，使用 disruptor创建消费者C1,C2.并行执行C1,C2 ，C1 C2 没有前后顺序
//        EventHandlerGroup<TradeData> handlerGroup = disruptor.handleEventsWith(new Handler1(), new Handler2());
        // 声明在C1 C2完事之后执行Handler3
//        handlerGroup.then(new Handler3());


        // 六边形操作
        Handler1 h1 = new Handler1();
        Handler2 h2 = new Handler2();
        Handler3 h3 = new Handler3();
//        Handler4 h4 = new Handler4();
//        Handler5 h5 = new Handler5();
//        disruptor.handleEventsWith(h1, h2);
//        disruptor.after(h1).handleEventsWith(h4);
//        disruptor.after(h2).handleEventsWith(h5);
//        disruptor.after(h4, h5).handleEventsWith(h3);

        // 顺序执行 h1-->h2-->h3
        disruptor.handleEventsWith(h1).handleEventsWith(h2).handleEventsWith(h3);

        disruptor.start();
        CountDownLatch latch = new CountDownLatch(1);
        executors.submit(new TradePublisher(latch, disruptor));
        latch.await();//等待生产者完事.

        disruptor.shutdown();
        executors.shutdown();
        System.out.println("总耗时:" + (System.currentTimeMillis() - beginTime));
    }
}
