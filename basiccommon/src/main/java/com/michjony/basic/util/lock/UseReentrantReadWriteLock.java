package com.michjony.basic.util.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/*
 * 支持读并发
 * 读写需要等待锁
 */
public class UseReentrantReadWriteLock {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock readLock = lock.readLock();
	private WriteLock writeLock = lock.writeLock();

	public void read() {
		try {
			readLock.lock();
			System.out.println("current thread read  enter : " + Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(1);
			System.out.println("current thread read  exit : " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			readLock.unlock();
		}
	}

	public void write() {
		try {
			writeLock.lock();
			System.out.println("current thread  write  enter : " + Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(1);
			System.out.println("current thread  write  exit : " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			writeLock.unlock();
		}
	}
	public static void main(String[] args) {
		final UseReentrantReadWriteLock lock = new UseReentrantReadWriteLock();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.read();
			}
		},"t1");
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.read();
			}
		},"t2");
		
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.write();
			}
		},"t3");
		
		//t1 t2 同时进入  
		t1.start();
		t2.start();
		t3.start();
	}
}
