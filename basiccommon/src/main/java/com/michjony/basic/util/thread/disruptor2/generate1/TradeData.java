package com.michjony.basic.util.thread.disruptor2.generate1;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义的 Event
 * user:Cherie
 * datetime;2019/7/7 15:19
 */
@Data
public class TradeData {

    private String id ;
    private String name ;
    private double price ;
    private AtomicInteger count = new AtomicInteger(0);
}
