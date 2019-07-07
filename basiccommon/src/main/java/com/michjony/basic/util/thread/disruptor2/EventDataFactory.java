package com.michjony.basic.util.thread.disruptor2;

import com.lmax.disruptor.EventFactory;

/**
 * 实现EventFactory接口
 * 用这个工厂批量的产生事件
 */
public class EventDataFactory implements EventFactory<EventData> {

    @Override
    public EventData newInstance() {
        return new EventData();
    }
}
