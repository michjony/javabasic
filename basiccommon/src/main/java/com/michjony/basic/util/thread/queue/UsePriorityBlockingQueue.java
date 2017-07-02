package com.michjony.basic.util.thread.queue;

import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.PriorityBlockingQueue;

import com.michjony.bean.Task;

public class UsePriorityBlockingQueue {
	public static void main(String[] args) {
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<>(10);
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("task1");
		Task t2 = new Task();
		t2.setId(5);
		t2.setName("task2");
		Task t3 = new Task();
		t3.setId(1);
		t3.setName("task3");
		Task t4 = new Task();
		t4.setId(7);
		t4.setName("task3");
		//不是每一个元素都是按优先顺序排序的，只保证头元素是最优先的
		q.add(t1);
		q.add(t2);
		q.add(t3);
		q.add(t4);
		
		System.out.println(q);
		
		for (Iterator<Task> iterator = q.iterator(); iterator.hasNext();) {
			Task task = (Task) iterator.next();
			System.out.println(task);
		}
		//当取出一个元素后，队列中的元素又会排序，头元素又是最优先元素
		q.poll();
		System.out.println(q);
		
		
	}
}
