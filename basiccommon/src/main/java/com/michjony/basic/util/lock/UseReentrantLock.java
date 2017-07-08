package com.michjony.basic.util.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 与 wait() notify() notifyAll() 一起使用
 * Lock 与 Condition一起使用
* @ClassName: UseReentrantLock 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Michael-jony 
* @date 2017年7月8日 下午6:37:53 
*
 */
public class UseReentrantLock {
	private Lock lock = new ReentrantLock();
	
	public  void  method1() {
		
		try {
			System.out.println("enter method1...");
			lock.lock();
			System.out.println("id：　"+ Thread.currentThread().getId());
			TimeUnit.SECONDS.sleep(2);
			System.out.println("id：　"+ Thread.currentThread().getId());
			System.out.println("exit method1...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	
	public void  method2() {
		
		try {
			System.out.println("enter method2...");
			lock.lock();
			System.out.println("id：　"+ Thread.currentThread().getId());
			TimeUnit.SECONDS.sleep(2);
			System.out.println("id：　"+ Thread.currentThread().getId());
			System.out.println("exit method2...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final UseReentrantLock useReentrantLock = new UseReentrantLock();
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				useReentrantLock.method1();
				useReentrantLock.method2();
			}
		});
		t1.start();
	}
}
