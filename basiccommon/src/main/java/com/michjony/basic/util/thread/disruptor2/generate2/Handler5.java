package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

/**
 * user:Cherie
 * datetime;2019/7/7 16:53
 */
public class Handler5 implements EventHandler<TradeData>, WorkHandler<TradeData> {

    @Override
    public void onEvent(TradeData event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler3:" + event);
    }

    @Override
    public void onEvent(TradeData event) throws Exception {
        System.out.println("h5: get price" + event.getPrice());
        event.setPrice(2 * event.getPrice());
    }
}
