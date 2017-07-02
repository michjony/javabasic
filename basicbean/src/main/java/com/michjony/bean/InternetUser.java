package com.michjony.bean;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class InternetUser implements Delayed{

	private String name ;
	private String id;
	private long endTime;
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	
	public InternetUser(){}
	public InternetUser(String name, String id, long endTime) {
		super();
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Delayed o) {
		InternetUser w = (InternetUser) o;
		return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1 : 0;
	}

	@Override
	public String toString() {
		return "InternetUser [name=" + name + ", id=" + id + ", endTime=" + endTime + ", timeUnit=" + timeUnit + "]";
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return endTime-System.currentTimeMillis();
	}

}
