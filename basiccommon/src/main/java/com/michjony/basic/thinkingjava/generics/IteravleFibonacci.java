package com.michjony.basic.thinkingjava.generics;

import java.util.Iterator;
import java.util.logging.Logger;

public class IteravleFibonacci extends Fibonacci implements Iterable<Integer> {

	private static final Logger logger = Logger.getLogger("IteravleFibonacci");
	//边界值，可输出的长度
	private int n;

	public IteravleFibonacci(int count) {
		n = count;
	}

	@Override
	public Iterator<Integer> iterator() {
		Iterator<Integer> iter = new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				logger.info("n:"+n);
				//控制输出的边界值
				n--; 
				return IteravleFibonacci.this.next();
			}

		};

		return iter;
	}
	
	
	public static void main(String[] args) {
		for (int i : new IteravleFibonacci(5)) {
			logger.info("i:" + i);
		}
		
		
	}

}
