package com.michjony.basic.util.thread;


public class VolatileNoAtomic extends 	Thread{

	private static volatile int count ;
	
	private static void addCount(){
		for (int i = 0; i < 1000; i++) {
			//非线程安全
			count ++ ;
		}
		System.out.println(count );
	}
	
	@Override
    public void run(){
		addCount();
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
		for (int i = 0; i <10 ; i++) {
			arr[i] = new VolatileNoAtomic();
		}
		for (int i = 0; i <10 ; i++) {
			arr[i].start();
		}
		//等待这些线程运行完成
		for (int i = 0; i <10 ; i++) {
			arr[i].join();
		}
		System.out.println("---" + count);
	}
}

