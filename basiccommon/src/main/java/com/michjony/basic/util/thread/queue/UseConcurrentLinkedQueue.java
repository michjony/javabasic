package com.michjony.basic.util.thread.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class UseConcurrentLinkedQueue {
	public static void main(String[] args) throws InterruptedException {
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>();
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.add("d");
		System.out.println(q.poll()); // 从头部取出元素 ，并从队列中删除
		System.out.println(q.size());
		System.out.println(q.peek()); // 从头部取出元素 ，并不删除队列元素
		System.out.println(q.size());
		
		
		ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(4);
		array.add("b");
		array.add("c");
		array.put("d");
		array.put("e");
		//2秒内加入元素 阻塞
		array.offer("a", 2, TimeUnit.SECONDS);
		
		LinkedBlockingQueue<String> bq = new LinkedBlockingQueue<>(5);
		bq.offer("a");
		bq.offer("b");
		bq.offer("c");
		bq.offer("d");
		bq.offer("e");
		bq.offer("f");
		System.out.println(bq.size());
		for (Iterator<String> iterator = bq.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		List<String> list = new ArrayList<String>();
		System.out.println(bq.drainTo(list,3));
		System.out.println(list);
		SynchronousQueue<String> sq = new SynchronousQueue<String>();
		sq.add("a");
	}
	
	
	
}
