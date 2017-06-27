package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;


public class MultiThread2 {
	private static int num = 0;

	/**
	 * static修饰 是类级别的方法，两个线程操作同一个数据，需要加锁保持线程安全
	 * 类锁
	 */
	public synchronized static void printNum(String tag) {
		try {
			if (tag.equals("a")) {
				num = 100;
				System.out.println("tag a set num over");
				TimeUnit.SECONDS.sleep(3);
			} else {
				num = 200;
				System.out.println("tag b set num over");
			}
			System.out.println("tag "+ tag +",num = " + num);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	public static void main(String[] args) {
		//m1和m2两个不同的对象
		final MultiThread2 m1 = new MultiThread2();
		final MultiThread2 m2 = new MultiThread2();
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				m1.printNum("a");
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				m2.printNum("b");
			}
		};	
		t1.start();
		t2.start();
	}

}

/**
 * 
tag a set num over
tag b set num over
tag b,num = 200
tag a,num = 100 (tag a 睡眠了)

 */
