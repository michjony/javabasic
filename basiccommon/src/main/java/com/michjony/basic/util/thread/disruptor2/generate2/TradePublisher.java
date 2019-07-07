package com.michjony.basic.util.thread.disruptor2.generate2;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.michjony.basic.util.thread.disruptor2.generate1.TradeData;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * user:Cherie
 * datetime;2019/7/7 17:37
 */
public class TradePublisher implements Runnable {

    Disruptor<TradeData> disruptor;

    private CountDownLatch latch;
    private static int LOOP = 10;

    public TradePublisher(CountDownLatch latch, Disruptor<TradeData> disruptor) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeEventTranslator = new TradeEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeEventTranslator);
        }
        latch.countDown();
    }
}

class TradeEventTranslator implements EventTranslator<TradeData> {

    private Random random=new Random();

    @Override
    public void translateTo(TradeData event, long sequence) {
        this.generateTrade(event);
    }

    private TradeData generateTrade(TradeData trade){
        trade.setPrice(random.nextDouble()*9999);
        return trade;
    }

}
