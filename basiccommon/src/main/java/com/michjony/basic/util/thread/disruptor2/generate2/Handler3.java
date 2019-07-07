package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.EventHandler;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

/**
 * user:Cherie
 * datetime;2019/7/7 16:53
 */
public class Handler3 implements EventHandler<TradeData> {

    @Override
    public void onEvent(TradeData event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("handler3:"+event);
    }
}
