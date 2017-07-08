package com.michjony.basic.util.thread.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
* @ClassName: UserCountDownLatch 
* @author Michael-jony 
* @date 2017年7月8日 下午2:39:18 
* 
 */
public class UserCountDownLatch {

	public static void main(String[] args) {

		final CountDownLatch countDown = new CountDownLatch(2);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("t1线程开始执行");
					//堵塞，等待被唤醒
					countDown.await();
					System.out.println("t1线程执行完毕");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace(System.out);
				}
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("t2线程进行初始化");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("t2线程初始化完毕，通知t1线程继续...");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace(System.out);
				}
				countDown.countDown();
			}
		}, "t2");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("t3线程进行初始化");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("t3线程初始化完毕，通知t1线程继续...");
					countDown.countDown();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace(System.out);
				}
			}
		}, "t3");

		t1.start();
		t2.start();
		t3.start();
	}
}
