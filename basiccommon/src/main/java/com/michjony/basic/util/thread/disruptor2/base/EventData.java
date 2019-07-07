package com.michjony.basic.util.thread.disruptor2.base;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 要生产的数据对象 , 传递到ringbuffer容器中，
 * 消费者注册一个事件监听事件
 */
@Data
public class EventData {
    private String value;
    private int id;
    private BigDecimal price;
}