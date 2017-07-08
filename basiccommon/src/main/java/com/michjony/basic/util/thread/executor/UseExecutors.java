package com.michjony.basic.util.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UseExecutors implements Runnable{

	public static void main(String[] args) {
		//固定个数的线程池
		ExecutorService threadPool1 = Executors.newFixedThreadPool(4);
		//一个线程的线程池
		ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
		//不限容量的线程池
		ExecutorService threadPool3 = Executors.newCachedThreadPool();
		//固定线程的计划线程池
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
	}

	@Override
	public void run() {
		System.out.println("");
		try {
			System.out.println("threadid : " + Thread.currentThread().getId() );
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
