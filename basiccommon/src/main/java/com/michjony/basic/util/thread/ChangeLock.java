package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class ChangeLock {
	private String lock = "lock";

	//修改被锁定的对象本身，两个线程锁定的就不是同一个对象
	void method() {
		synchronized (lock) {
			try {
				System.out.println("Thread  ： " + Thread.currentThread().getName() + " , start");
				//勿在锁中修改锁定的对象
				lock = "change lock";
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Thread  ： " + Thread.currentThread().getName() + " , end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		final ChangeLock changeLock = new ChangeLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				changeLock.method();

			}
		}, "t1");
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				changeLock.method();

			}
		}, "t2");
		t2.start();
	}
}
