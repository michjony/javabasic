package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class StringLock {

	void method() {
		// 锁定字符串常量 在常量池中， 只有一个引用 ，只有t1 会执行  ，可以使用 new String("abc")
		synchronized ("abc") {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName() + " start ");
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName() + " end ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final StringLock stringLock = new StringLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				stringLock.method();
			}
		}, "T1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				stringLock.method();
			}
		}, "T2");

		t1.start();
		t2.start();
	}

}
