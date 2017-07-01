package com.michjony.basic.util.thread.communication;

import java.util.concurrent.TimeUnit;

public class ConnThreadLocal {
	///每个线程单独使用
	public static  ThreadLocal<String> th = new ThreadLocal<>();
	
	public void setTh(String value){
		th.set(value);
	}
	public void getTh() {
		System.out.println(Thread.currentThread().getName() + " : " + this.th.get());
	}
	
	public static void main(String[] args) {
		final ConnThreadLocal ct = new ConnThreadLocal();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ct.setTh("t1");
				ct.getTh();
			}
		},"t1");
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					ct.getTh();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t2");
		t2.start();
		
	}
}
