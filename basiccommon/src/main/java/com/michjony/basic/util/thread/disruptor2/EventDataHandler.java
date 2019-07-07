package com.michjony.basic.util.thread.disruptor2;


import com.lmax.disruptor.EventHandler;

import java.time.LocalDateTime;

/**
 * 事件消费者，也就是一个事件处理器，这个事件处理器简单地把事件中存储的数据打印到终端
 * 实现事件处理器接口类
 */
public class EventDataHandler implements EventHandler<EventData> {

    /**
     * 具体的消费逻辑，转换数据，入库
     *
     * @param event
     * @param sequence
     * @param endOfBatch
     * @throws Exception
     */
    @Override
    public void onEvent(EventData event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(LocalDateTime.now() + ":" + event);
    }
}
