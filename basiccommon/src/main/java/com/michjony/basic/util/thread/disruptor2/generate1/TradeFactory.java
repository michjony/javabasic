package com.michjony.basic.util.thread.disruptor2.generate1;

import com.lmax.disruptor.EventFactory;

/**
 * user:Cherie
 * datetime;2019/7/7 15:21
 */
public class TradeFactory implements EventFactory<TradeData> {
    @Override
    public TradeData newInstance() {
        return new TradeData();
    }
}
