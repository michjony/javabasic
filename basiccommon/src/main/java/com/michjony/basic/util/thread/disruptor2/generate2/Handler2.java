package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

import java.util.concurrent.TimeUnit;

/**
 * user:Cherie
 * datetime;2019/7/7 16:53
 */
public class Handler2 implements EventHandler<TradeData>, WorkHandler<TradeData> {

    @Override
    public void onEvent(TradeData event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    @Override
    public void onEvent(TradeData event) throws Exception {
        System.out.println("handler2: set price");
        event.setPrice(17.0);
//        TimeUnit.SECONDS.sleep(1);
    }
}
