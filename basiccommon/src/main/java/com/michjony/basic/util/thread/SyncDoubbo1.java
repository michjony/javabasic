package com.michjony.basic.util.thread;

/**
 * 同一个对象嵌套调用synchronized 是线程安全的
* @ClassName: SyncDoubbo1 
* @author Michael-jony 
* @date 2017年6月29日 下午9:07:23 
*
 */
public class SyncDoubbo1 {
	
	private synchronized void method1() {
		System.out.println("method1..");
		method2();
	}
	
	private synchronized void method2() {
		System.out.println("method2..");
		method3();
	}
	
	private synchronized void method3() {
		System.out.println("method3..");
		
	}
	
	public static void main(String[] args) {
		final SyncDoubbo1 sd = new SyncDoubbo1();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				sd.method1();
			}
		});
		t1.start();
	}
	
}
