package com.michjony.basic.util.thread.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent>{

	@Override
	public void onEvent(LongEvent event, long l, boolean b) throws Exception {
		System.out.println(event.getValue() + "event has published");
	}

}
