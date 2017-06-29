package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class ObjectLock {
	//当前实例对象锁
	void method1() {
		synchronized (this) {
			try {
				System.out.println("do method1..");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	// 类锁
	void method2() {
		synchronized (ObjectLock.class) {
			try {
				System.out.println("do method2..");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private Object oLock = new Object();;

	// 任意对象锁
	void method3() {
		synchronized (oLock) {
			try {
				System.out.println("do method3..");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void main(String[] args) {

		final ObjectLock objLock = new ObjectLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				objLock.method1();

			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				objLock.method2();

			}
		});
		t2.start();
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				objLock.method3();

			}
		});
		t3.start();
	}
}
