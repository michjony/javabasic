package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

/**
 * 脏读
 * set值的时候，避免read值
 * @ClassName: DirtyRead
 * @author Michael-jony
 * @date 2017年6月27日 下午8:19:54
 *
 */
public class DirtyRead {
	private String username = "a1";
	private String password = "b2";

	synchronized void getValue() {
		System.out.println("getValue username : " + username + "; password : " + password);
	}

	private synchronized void setValue(String username, String password) {
		this.username = username;
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue username : " + username + "; password : " + password);
	}

	public static void main(String[] args) throws InterruptedException {
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("c3", "123");
			}
		});
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		dr.getValue();
	}
}
