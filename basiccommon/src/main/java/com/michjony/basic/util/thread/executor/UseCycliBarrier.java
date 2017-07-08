package com.michjony.basic.util.thread.executor;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: UseCycliBarrier
 * @author Michael-jony
 * @date 2017年7月8日 下午3:56:40
 *
 */
public class UseCycliBarrier {

	static class Runner implements Runnable {

		private CyclicBarrier barrier;
		private String name;

		Runner(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(new Random(47).nextInt(5));
				System.out.println(name + " 准备OK");
				// 等待
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(name + " go!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// 使用同一个CyclicBarrier
		Future<?> future1 = executorService.submit(new Thread(new Runner(barrier, "zhangshan")));
		Future<?> future2 = executorService.submit(new Thread(new Runner(barrier, "wangwu")));
		Future<?> future3 = executorService.submit(new Thread(new Runner(barrier, "lisi")));
		executorService.shutdown();
		while (true) {
			if (future1.isDone() && future2.isDone() && future3.isDone()) {
				System.out.println("all future over");
				break;
			}
		}
		System.out.println("all over");
	}

}
