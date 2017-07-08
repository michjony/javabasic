package com.michjony.basic.util.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock产生Condition 
* @ClassName: UseCondition 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Michael-jony 
* @date 2017年7月8日 下午6:50:43 
*
 */
public class UseCondition {

	private Lock lock = new ReentrantLock();
	// 获取锁的实例
	private Condition condition = lock.newCondition();

	private void method1() {
		try {
			lock.lock();
			System.out.println("ID : " + Thread.currentThread().getId());
			//sleep 不释放锁
			TimeUnit.SECONDS.sleep(2);
			System.out.println("释放锁 ： " + Thread.currentThread().getId());
			// 释放锁
			condition.await();
			System.out.println("id : " + Thread.currentThread().getId() + " 继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void method2() {
		try {
			lock.lock();
			System.out.println("ID : " + Thread.currentThread().getId());
			TimeUnit.SECONDS.sleep(2);
			System.out.println("释放锁 ： " + Thread.currentThread().getId());
			condition.signal();
			System.out.println("method2通知");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final UseCondition uc = new UseCondition();
		new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method1();

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				uc.method2();

			}
		}).start();

	}
}
