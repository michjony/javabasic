package com.michjony.basic.util.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse extends 	Thread{

	private static  AtomicInteger count = new AtomicInteger(0);
	
	//多个原子性操作需要使用synchronized加锁
	private synchronized static int multiadd(){
		count.addAndGet(1);		
		count.addAndGet(2);		
		count.addAndGet(3);		
		count.addAndGet(4);		
		return count.get();
	}
	

	public static void main(String[] args) throws InterruptedException {
		final AtomicUse au = new AtomicUse();
		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			ts.add(new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(au.multiadd());
				}
			}));
		}
		
		for (Thread thread : ts) {
			thread.start();
		}
		for (Thread thread : ts) {
			thread.join();
		}
		System.out.println("---" + count);
	}
}

