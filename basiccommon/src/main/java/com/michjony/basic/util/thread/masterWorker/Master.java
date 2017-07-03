package com.michjony.basic.util.thread.masterWorker;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.michjony.bean.Task;

public class Master {
	// 承载任务的集合
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();
	// 承载所有的worker对象
	private HashMap<String, Thread> workers = new HashMap<>();
	// 使用一个容器承载每一个worker 并行执行任务的结果集
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	// 构造方法
	public Master(Worker worker, int workerCount) {
		// 每一个Worker对象都需要有Master的引用
		worker.setWorkerQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for (int i = 0; i < workerCount; i++) {
			workers.put("子节点" + Integer.toString(i), new Thread(worker));
		}
	}

	// 提交方法
	public void submit(Task task) {
		this.workQueue.add(task);
	}
	
	// 需要一个执行的方法，（启动应用程序，让所有的worker工作）
	public void execte(){
		for (Map.Entry<String, Thread> th : workers.entrySet()) {
			th.getValue().start();
		}
	}

	//判断线程是否执行完毕
	public boolean isComplete() {
		for (Map.Entry<String, Thread> th : workers.entrySet()) {
			if(th.getValue().getState() != Thread.State.TERMINATED){
				return false ;
			}
		}
		return true ;
	}

	//返回结果集
	public int getResult() {
		int ret = 0;
		for ( Map.Entry<String,	 Object> mEntry : resultMap.entrySet()) {
			ret += (Integer)mEntry.getValue();
		}
		return ret;
	}
	
	
}
