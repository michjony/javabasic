package com.michjony.basic.util.thread.masterWorker;

import com.michjony.bean.Task;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		long start = System.currentTimeMillis();
		Master master = new  Master(new Worker() , 10);
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("task"+i);
			master.submit(task);
		}
		
		master.execte();
		while (true) {
			if (master.isComplete()) {
				long end = System.currentTimeMillis();
				System.out.println("start : " + start +  " ; end : " + end );
				System.out.println("任务处理完成");
				System.out.println(master.getResult());
				break ;
			}
		}
		
	}
	
}
