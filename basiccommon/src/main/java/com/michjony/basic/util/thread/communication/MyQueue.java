package com.michjony.basic.util.thread.communication;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	// 1 . 需要一个承载元素的集合
	private final LinkedList<Object> list = new LinkedList<>();
	
	// 2 . 需要一个计数器
	private AtomicInteger count = new AtomicInteger(0);
	
	// 3 . 需要指定上限和下限
	private final int minSize = 0;
	
	private final int maxSize ;
	
	//构造器
	public MyQueue(int size){
		maxSize = size;
	}
	// 5 . 初始化一个对象 用于加锁
	private Object lock = new Object();
	
	// 加入元素
	public void put(Object obj) {
		synchronized (lock) {
			if (count.get()==this.maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//1 加入
			list.add(obj);
			//2计数器加1
			count.incrementAndGet();
			System.out.println("new element put : " + obj);
			//3唤醒
			lock.notify();
		}
	}
	
	//获取元素
	public Object take() {
		Object re = null ;
		synchronized (lock) {
			if (count.get()==this.minSize) {
				try {
					lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//1 移除
			re = list.removeFirst();
			//2 计数器减1
			count.decrementAndGet();
			//3 唤醒
			lock.notify();
		}
		return re;
	}
	
	
	public int getSize() {
		return this.count.get();
	}
	
	
	public static void main(String[] args) {
		final MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		System.out.println("size : " + mq.getSize() );
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				mq.put("f");
				mq.put("g");
			}
		},"t1");
		
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Object object =  mq.take();
				System.out.println("remove element : " + object);
				Object object2 =  mq.take();
				System.out.println("remove element : " + object2);
			}
			
		},"t2");
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		
	}
}
