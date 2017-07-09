package com.michjony.basic.util.thread.disruptor.generate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 每笔订单交易数据
* @ClassName: Trade 
* @author Michael-jony 
* @date 2017年7月9日 下午1:17:29 
*
 */
public class Trade {
	
	
	private String id ;
	private String name;
	private double price;
	private AtomicInteger count = new AtomicInteger(0);
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AtomicInteger getCount() {
		return count;
	}
	public void setCount(AtomicInteger count) {
		this.count = count;
	}
	
	
}
