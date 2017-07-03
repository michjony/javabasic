package com.michjony.basic.util.thread.masterWorker;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

import com.michjony.bean.Task;

public class Worker implements Runnable{
	//每一个worker对象
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap ;

	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		while(true){
			Task task = this.workQueue.poll();
			if(null==task){
				break ; 
			}
			//业务处理
			Random random = new Random();
			try {
				Object object = random.nextInt(100);
				TimeUnit.SECONDS.sleep(random.nextInt(2));
				this.resultMap.put(Integer.toString(task.getId()), object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
