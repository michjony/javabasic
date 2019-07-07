package com.michjony.basic.util.thread.disruptor2.generate1;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

/**
 * user:Cherie
 * datetime;2019/7/7 15:56
 */
public class TradeDataHandler implements EventHandler<TradeData>, WorkHandler<TradeData> {

    @Override
    public void onEvent(TradeData event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    @Override
    public void onEvent(TradeData event) throws Exception {
        //这里做具体的消费逻辑
        event.setId(UUID.randomUUID().toString());//简单生成下ID
        System.out.println(event.getId());
    }
}
