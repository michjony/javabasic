package com.michjony.basic.util.thread.queue;

import java.util.concurrent.DelayQueue;

import com.michjony.bean.InternetUser;

public class UseDelay implements Runnable{

	
	public boolean yinye = true ;
	
	/**
	 * 带有延迟时间的队列
	 */
	private DelayQueue<InternetUser> queue = new DelayQueue<>();

	public void shangji(String name,String id,int money) {
		InternetUser user = new InternetUser(name , id , 1000 * money + System.currentTimeMillis());
		System.out.println("网名 ： " + user.getName() + " ; id :" + user.getId() + "交钱 :"+money + "开始上机");
		this.queue.add(user);
	}
	public void xiaji(InternetUser user) {
		System.out.println("网名 ： " + user.getName() + " ; id :" + user.getId() + "时间到 下机。。。");
	}
	@Override
	public void run() {
		while (yinye) {
			try {
				//拿的第一个元素一定是队列的头
				InternetUser user = queue.take();
				xiaji(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("start....");
		UseDelay start = new UseDelay();
		Thread shangwangThread  = new Thread(start);
		shangwangThread.start();
		//TODO
		/*
		start.shangji("user1","1111", 4);
		start.shangji("user2","2222", 10);
		start.shangji("user3","3333", 5);
		*/
		
		start.shangji("user1","1111", 10);
		start.shangji("user2","2222", 4);
		start.shangji("user3","3333", 5);
		System.out.println(start.queue);
	}
}
