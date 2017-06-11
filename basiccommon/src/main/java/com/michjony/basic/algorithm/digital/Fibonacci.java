package com.michjony.basic.algorithm.digital;

/**
 * 斐波那契数列 ：每个数字(从第三个数字开始)都是由前两个数字之和
* @ClassName: Fibonacci 
* @author Michael-jony 
* @date 2017年6月11日 下午2:32:36 
*
 */
public class Fibonacci {
	
	//递归
	static long fib(int n){
		if( n==1 || n==2 ){
			return 1 ;
		}
		return fib(n-1)+fib(n-2);
	}
	
	//非递归
	static long fib2(int n){  
		if(n<3){
			return 1;
		}
		long a = 1;
		long b = 1;
		for (int i = 2; i < n-1; i++) {
			b = a + b;
			a = b - a ;
		}
		return a + b ;
	}	
	public static void main(String[] args) {
		int count = 50 ;
		long beginTime = System.currentTimeMillis();
		for (int i = 1; i <= count; i++) {
			long a = fib(i);
			System.out.print(a);
			if(i<count){
				System.out.print(" , ");
			}
		}
		System.out.println("\n");
		System.out.println("耗时1 ： " + (System.currentTimeMillis() -beginTime ) + "ms");
		
		beginTime = System.currentTimeMillis();
		for (int i = 1; i <= count; i++) {
			long a = fib2(i);
			System.out.print(a);
			if(i<count){
				System.out.print(" , ");
			}
		}
		System.out.println("\n");
		System.out.println("耗时2 ： " + (System.currentTimeMillis() -beginTime ) + "ms");
	}

}
