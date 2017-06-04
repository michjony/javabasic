package com.michjony.pattern.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 测试生产者-消费者模式
* @author Michael-jony 
* @date 2017年6月4日 下午12:15:55 
*
 */
public class TestProducerAndConsumer {
	
	public static void main(String[] args) {
		
		BlockingQueue<MapData> queue = new LinkedBlockingQueue<>();
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		Consumer consumer4 = new Consumer(queue);
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(producer1);
		es.execute(producer2);
		es.execute(producer3);
		es.execute(consumer1);
		es.execute(consumer2);
		es.execute(consumer3);
		es.execute(consumer4);
		try {
			TimeUnit.SECONDS.sleep(5);
			producer1.stop();
			producer2.stop();
			producer3.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		es.shutdown();
		System.out.println(123);
		Thread.currentThread().stop();
		System.out.println(234);
	}
}
