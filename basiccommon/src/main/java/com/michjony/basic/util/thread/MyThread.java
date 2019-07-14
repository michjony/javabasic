package com.michjony.basic.util.thread;

public class MyThread extends Thread{
	private static int count = 1; 
	//private volatile static int count = 5; 
	
	/**
	 * 使用synchronized 依然不是线程安全的
	 */
	@Override
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName() + " : " + count);

		count++ ;
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		for (int i = 0; i < 1000000; i++) {
			Thread t1 = new Thread(myThread, "t1");
			Thread t2 = new Thread(myThread, "t2");
			Thread t3 = new Thread(myThread, "t3");
			Thread t4 = new Thread(myThread, "t4");
			Thread t5 = new Thread(myThread, "t5");
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		}
	}
	
}
