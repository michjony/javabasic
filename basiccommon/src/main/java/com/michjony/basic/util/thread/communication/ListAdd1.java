package com.michjony.basic.util.thread.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ListAdd1 {

	private volatile static List<String> list = new ArrayList<>();

	public void add() {
		list.add(new Random().nextInt(10) + "");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		final ListAdd1 list1 = new ListAdd1();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						list1.add();
						System.out.println("current name :" + Thread.currentThread().getName() + " add element ");
						TimeUnit.SECONDS.sleep(1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");
	

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (list1.size() == 5) {
						System.out.println(
								"current thread " + Thread.currentThread().getName() + " list.size() :" + list.size());
						//t2抛出异常并未阻止t1线程
						throw new RuntimeException();
					}
				}
			}
		}, "t2");
		
		t1.start();
		t2.start();

	}
}
