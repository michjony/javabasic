package com.michjony.pattern.producer;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * @ClassName: Producer
 * @author Michael-jony
 * @date 2017年6月3日 下午9:22:30
 *
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	//原子操作
	private static AtomicInteger count = new AtomicInteger();

	// 内存缓存区
	private BlockingQueue<MapData> queue;

	public Producer(BlockingQueue<MapData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		MapData mapdata = null;
		Random r = new Random();
		System.out.println();

		try {
			while (isRunning) {
				TimeUnit.SECONDS.sleep(r.nextInt(2));
				mapdata = new MapData(count.incrementAndGet());
				System.out.println(new Date() + " ; current thread-id : " + Thread.currentThread().getId() + " , put mapdata : < "+ mapdata +" >into queue .");
				//Inserts the specified element into this queue, waiting up to the
			    //specified wait time if necessary for space to become available.
				if( !queue.offer(mapdata,1,TimeUnit.SECONDS)){
					System.out.println(new Date() + " ; failed to put data : " + mapdata);
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			//中断线程
			Thread.currentThread().interrupt();
		}
	}

	public void stop() {
		isRunning = false;
	}
}
