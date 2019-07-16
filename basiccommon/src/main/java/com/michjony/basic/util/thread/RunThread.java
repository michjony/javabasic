package com.michjony.basic.util.thread;

import java.util.concurrent.TimeUnit;

public class RunThread extends Thread {
	//必須加上volatile  使多個線程可見
	private volatile boolean isRunning = true;

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
    public void run() {
		System.out.println("進入run");
		while(isRunning){
			
		}
		System.out.println("線程終止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread runThread = new RunThread();
		runThread.start();
		TimeUnit.SECONDS.sleep(3);
		runThread.setRunning(false);
		System.out.println("isrunning set to false");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(runThread.isRunning);
	}
}
