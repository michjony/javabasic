package com.michjony.basic.util.thread.disruptor2.base;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

/**
 * * Disruptor 3.0提供了lambda式的API。这样可以把一些复杂的操作放在Ring Buffer，
 * * 所以在Disruptor3.0以后的版本最好使用Event Publisher或者Event Translator来发布事件
 * 2019/7/7 14:56
 */
public class EventDataProducerWithTranslator {

    /**
     * 一个translator可以看做一个事件初始化器，publicEvent方法会调用它
     */
//    private static final EventTranslatorOneArg<EventData, ByteBuffer> TRANSLATOR = new EventTranslatorOneArg<EventData, ByteBuffer>() {
//
//        @Override
//        public void translateTo(EventData event, long sequence, ByteBuffer buffer) {
//            event.setValue(String.valueOf(buffer.getLong(0)));
//            event.setId(Integer.parseInt(event.getValue()));
//            event.setPrice(new BigDecimal("1.1"));
//        }
//    };

    private static final EventTranslatorOneArg<EventData, ByteBuffer> TRANSLATOR = (
            (EventData event, long sequence, ByteBuffer buffer) -> {
                // 填充Event
                event.setValue(String.valueOf(buffer.getLong(0)));
                event.setId(Integer.parseInt(event.getValue()));
                event.setPrice(new BigDecimal("1.1"));
            }
    );

    private final RingBuffer<EventData> ringBuffer;

    public EventDataProducerWithTranslator(RingBuffer<EventData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        ringBuffer.publishEvent(TRANSLATOR, buffer);
    }


}
