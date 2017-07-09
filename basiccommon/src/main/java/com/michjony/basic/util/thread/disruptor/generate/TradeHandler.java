package com.michjony.basic.util.thread.disruptor.generate;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeHandler implements EventHandler<Trade> , WorkHandler<Trade>{

	//WorkHandler
	@Override
	public void onEvent(Trade event) throws Exception {
		this.onEvent(event);
	}

	//EventHandler
	@Override
	public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
		//消费者逻辑
		event.setId(UUID.randomUUID().toString());
		System.out.println(event.getId());
	}

}
