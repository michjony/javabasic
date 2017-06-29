package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

/**
 * 同一对象属性的修改不会影响锁的情况
* @ClassName: ModifyLock 
* @author Michael-jony 
* @date 2017年6月29日 下午9:47:14 
*
 */
public class ModifyLock {
	private String name ;
	private int age ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public synchronized void changeAttributte(String name, int age) {
		try {
			System.out.println("当前线程 : "  + Thread.currentThread().getName() + " 开始");
			this.setName(name);
			this.setAge(age);
			
			System.out.println("当前线程 : "  + Thread.currentThread().getName() + " 修改对象内容为： " 
					+ this.getName() + ", " + this.getAge());
			
			TimeUnit.SECONDS.sleep(3);
			System.out.println("当前线程 : "  + Thread.currentThread().getName() + " 结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		final ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				modifyLock.changeAttributte("a", 1);
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				modifyLock.changeAttributte("b", 2);
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
