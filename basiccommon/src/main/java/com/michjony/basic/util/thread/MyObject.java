package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class MyObject {

	private synchronized void method1() {
		try {
			System.out.println("method1 : " +Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void method2() {
		System.out.println("method2 : " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		final MyObject mObject = new MyObject();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//t1 线程获取mObject的锁
				mObject.method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//t2 不需要获取mObject的锁
				mObject.method2();
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
}
