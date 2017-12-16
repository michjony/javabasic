package com.michjony.basic.thinkingjava.generics.ex7;

import java.util.Iterator;

import com.michjony.basic.thinkingjava.generics.Fibonacci;

public class AdapterFibonacci implements Iterable<Integer> {
	//注入Fibonacci
	private Fibonacci fib;
	private int n;

	public AdapterFibonacci(Fibonacci fib, int n) {
		this.fib = fib;
		this.n = n;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				return n > 0 ;
			}

			@Override
			public Integer next() {
				n-- ;
				return fib.next();
			}
			
		};
	}

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		AdapterFibonacci af = new AdapterFibonacci(fib,18);
		for (Integer i : af) {
			System.out.print(i + " ");
		}
	}
}
