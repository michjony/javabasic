package com.michjony.basic.util.thread.callfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Future 用于耗时较久的业务
* @ClassName: UseFuture 
* @author Michael-jony 
* @date 2017年7月8日 下午4:10:51 
*
 */
public class UseFuture implements Callable<String> {

	private String para ; 
	UseFuture(String para){
		this.para = para;
	}
	
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(5);
		String result = this.para + " worked done" ;
		return result;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		String qString = "query";
		FutureTask<String> futureTask = new FutureTask<String>(new UseFuture(qString));
		FutureTask<String> futureTask2 = new FutureTask<String>(new UseFuture(qString));
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//execute 与  submit 区别 ：
		//1:  submit 可以传入实现了Callable接口的实例对象
		//2:  submit 方法有返回值
		Future f1 = executorService.submit(futureTask); 
		Future f2 = executorService.submit(futureTask2); 
		//executorService.execute(futureTask);
		System.out.println("请求完成");
		try {
			TimeUnit.SECONDS.sleep(1);
			//System.out.println(f1.get());
			System.out.println("业务处理逻辑。。。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//futureTask异步获取值
		System.out.println(futureTask.get());
		System.out.println(futureTask2.get());
		executorService.shutdown();
		System.out.println((System.currentTimeMillis() - start )/1000);
	}


}
