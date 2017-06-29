package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

/**
 * 有父子继承关系时，都加synchronized 是线程安全的。
* @ClassName: SyncDoubbo2 
* @author Michael-jony 
* @date 2017年6月29日 下午9:06:44 
*
 */
public class SyncDoubbo2 {
	static class Main{
		public int i = 10 ;
		
		public synchronized void operationSup(){
			try {
				i--;
				System.out.println("Main print i = " + i);
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static class Sub extends Main{
		public synchronized void operationSub(){
			try {
				while (i > 0) {
					i--;
					System.out.println("Sub print i = " + i);
					TimeUnit.SECONDS.sleep(1);
					this.operationSup();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sub sub  = new Sub();
				sub.operationSub();
			}
		});
		thread.start();
	}
}
