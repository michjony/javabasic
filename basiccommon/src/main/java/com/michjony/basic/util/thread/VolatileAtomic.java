package com.michjony.basic.util.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomic extends 	Thread{

	private static  AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount(){
		for (int i = 0; i < 1000; i++) {
			//非线程安全
			count.incrementAndGet();
		}
		System.out.println(count);
	}
	
	public void run(){
		addCount();
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileAtomic[] arr = new VolatileAtomic[10];
		for (int i = 0; i <10 ; i++) {
			arr[i] = new VolatileAtomic();
		}
		for (int i = 0; i <10 ; i++) {
			arr[i].start();
		}
		
		//等待这些线程运行完成
		for (int i = 0; i <10 ; i++) {
			arr[i].join();
		}
		System.out.println("---" + count);
		
	}
}

