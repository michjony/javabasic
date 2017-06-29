package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class SyncException {
	private int i = 0;

	private synchronized void operation() {
		while (true) {
			i++;
			try {
				TimeUnit.SECONDS.sleep(1);

				System.out.println(Thread.currentThread().getName() + " , i = " + i);
				if (i == 10) {
					Integer.parseInt("a");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("log info i = " + i);
				//继续处理其他
				continue;
			}
		}
	}

	public static void main(String[] args) {
		SyncException syncException = new SyncException();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				syncException.operation();
			}
		});
		thread.start();
	}
}
