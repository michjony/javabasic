package com.michjony.basic.util.thread.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {

	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * @Title: onData 用于发布事件 ,每调用一次就发布一次事件
	 * @param @param bb @return void @throws
	 */
	public void onData(ByteBuffer bb) {
		// 1 可以把ringBuffer看做一个事件队列 next 就是得到下面一个事件器
		long sequence = ringBuffer.next();
		try {

			// 2 用上面的索引取出一个空的事件用于填充（获得该序号对应的事件对象）
			LongEvent event = ringBuffer.get(sequence);
			// 3 获取要通过事件传递的业务数据
			event.setValue(bb.getLong());
		} finally {
			// 4.发布事件
			ringBuffer.publish(sequence);
		}
	}

}
