package com.michjony.basic.util.thread.callfuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量 、 PV : 网站总访问量，页面浏览量或点击量 用户每刷新一次就会被记录一下 UV : 访问网站的一台电脑客户端为一个访客 QPS :
 * 每秒查询数，qps很大程度上代表了业务系统上的繁忙程度，每次请求的背后，多次磁盘IO 和多个网络请求，多个cpu时间片 RT : 请求的响应时间
 * 
 * @ClassName: UseSemaphore
 * @author Michael-jony
 * @date 2017年7月8日 下午5:08:30 
 * 1：网络 2：服务 ->业务 LVS HA-proxy nginx 3：java ——> 限流
 * 
 * redis做限流限制:
 * 用户信息放入redis,访问当前页面次数放入redis中，统计次数放入redis中，超多一定次数，就限制访问
 */
public class UseSemaphore {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		//只有5个线程同时访问 限流
		final Semaphore semp = new Semaphore(5);
		//同时启动20个请求
		for (int i = 0; i < 20; i++) {
			final int NO = i;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						//获取许可
						semp.acquire();
						System.out.println("accessing :" + NO);
						TimeUnit.SECONDS.sleep(2);
						//释放许可
						semp.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.submit(run);
		}

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		exec.shutdown();
	}
}
