package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;


public class MultiThread {
	private int num = 0;

	public void printNum(String tag) {
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
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();
		
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
