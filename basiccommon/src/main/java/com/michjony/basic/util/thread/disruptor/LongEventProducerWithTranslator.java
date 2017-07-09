package com.michjony.basic.util.thread.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * EventTranslatorOneArg使用
 * 将数据表示转换为给定事件中设置的字段
* @ClassName: LongEventProducerWithTranslator 
* @author Michael-jony 
* @date 2017年7月9日 下午1:11:11 
*
 */
public class LongEventProducerWithTranslator {
	private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRAN = new EventTranslatorOneArg<LongEvent, ByteBuffer>() {

		@Override
		public void translateTo(LongEvent event, long sequence, ByteBuffer arg0) {
			event.setValue(arg0.getLong());
		}

	};

	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer buffer) {
		ringBuffer.publishEvent(TRAN, buffer);
	}

}
