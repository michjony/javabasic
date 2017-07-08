package com.michjony.basic.util.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock产生多个Condition 
* @ClassName: UseCondition 
* @author Michael-jony 
* @date 2017年7月8日 下午6:50:43 
*
 */
public class UseManyCondition {

	private Lock lock = new ReentrantLock();
	// 获取锁的实例
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();

	private void method1() {
		try {
			lock.lock();
			System.out.println("当前线程 : " + Thread.currentThread().getName());
			//sleep 不释放锁
			TimeUnit.SECONDS.sleep(2);
			System.out.println("当前线程释放锁 ： " + Thread.currentThread().getName());
			// 释放锁
			c1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void method2() {
		try {
			lock.lock();
			System.out.println("当前线程 : " + Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(2);
			System.out.println("当前线程释放锁 ： " + Thread.currentThread().getName());
			c1.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void method3() {
		try {
			lock.lock();
			System.out.println("当前线程 : " + Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(2);
			System.out.println("当前线程释放锁 ： " + Thread.currentThread().getName());
			c2.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	private void method4() {
		try {
			lock.lock();
			System.out.println("当前线程 : " + Thread.currentThread().getName() +  " 唤醒");
			TimeUnit.SECONDS.sleep(1);
			c1.signalAll();
			System.out.println("c1通知");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	private void method5() {
		try {
			lock.lock();
			System.out.println("当前线程: " + Thread.currentThread().getName() + " 唤醒");
			c2.signal();
			System.out.println("c2通知");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final UseManyCondition uc = new UseManyCondition();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method1();

			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method2();

			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method3();

			}
		},"t3");
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method4();

			}
		},"t4");
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method5();

			}
		},"t5");
		
		t1.start(); //c1
		t2.start();//c1
		t3.start();//c2
		
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(2));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t4.start(); //c1
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(2));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t5.start(); //c2
	}
}
