package com.michjony.pattern.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 消费者
 * 
 * @ClassName: Consumer
 * @author Michael-jony
 * @date 2017年6月4日 下午12:00:50
 *
 */
public class Consumer implements Runnable {

	// 缓冲区
	private BlockingQueue<MapData> queue;

	public Consumer(BlockingQueue<MapData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random r = new Random();
		try {
			while (true) {
				//Retrieves and removes the head of this queue, 
				//waiting if necessary until an element becomes available.
				MapData mapdata = queue.take();
				System.out.println(" consumer id = " + Thread.currentThread().getId() + "  , get data : " + mapdata);
				TimeUnit.SECONDS.sleep(r.nextInt(2));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
