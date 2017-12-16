package com.michjony.basic.thinkingjava.generics;

import com.michjony.basic.util.Generator;

/**
 * 生成Fibonacci序列 <B>thinking java</B><BR>
 * <B>generics</B><BR>
 * 
 * @author Mark
 * @since 2017年12月16日 下午10:24:52
 */
public class Fibonacci implements Generator<Integer> {

	private int count = 0;

	private int fib(int n) {
		if (n < 0) {
			return 0;
		}
		if (n < 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	@Override
	public Integer next() {
		return fib(count++);
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 10; i++) {
			System.out.print(gen.next() + " ");
		}
	}

}
