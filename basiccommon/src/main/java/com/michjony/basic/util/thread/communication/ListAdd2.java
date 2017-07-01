package com.michjony.basic.util.thread.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ListAdd2 {

	private volatile static List<String> list = new ArrayList<>();

	public void add() {
		list.add(new Random().nextInt(10) + "");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		final ListAdd2 list1 = new ListAdd2();
		
		final Object lock = new Object();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (lock) {

						for (int i = 0; i < 10; i++) {
							list1.add();
							System.out.println("current name :" + Thread.currentThread().getName() + " add element ");
							TimeUnit.SECONDS.sleep(1);

							if (list1.size() == 5) {
								System.out.println("发出通知..");
								//不释放锁 ，唤醒t2线程
								lock.notify();
								return ;
							}
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					if (list1.size() != 5) {
						try {
							System.out.println("t2 enter..");
							//等待  释放锁 
							lock.wait(); //调用 t1线程
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					System.out.println("current thread : " + Thread.currentThread().getName() + " get notify");
					throw new RuntimeException();
				}
			
			}
		}, "t2");
		//需要t2先执行，获得lock锁，再等待lock锁
		t2.start();
		t1.start();

	}
}
