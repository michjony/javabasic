package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

/**
 * user:Cherie
 * datetime;2019/7/7 16:53
 */
public class Handler4 implements EventHandler<TradeData>, WorkHandler<TradeData> {

    @Override
    public void onEvent(TradeData event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler3:" + event);
    }

    @Override
    public void onEvent(TradeData event) throws Exception {
        System.out.println("h4:" + event.getName());
        event.setName(event.getName()+":h4");
    }
}
