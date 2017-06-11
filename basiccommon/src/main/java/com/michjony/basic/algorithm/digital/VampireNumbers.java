package com.michjony.basic.algorithm.digital;

public class VampireNumbers {
	
	static int a(int i){
		return i / 1000;
	}
	
	static int b(int i){
		return i/100 % 10 ;
	}
	static int c(int i){
		return i/10%10;
	}
	static int d(int i){
		return i%10 ;
	}
	
	static int com(int a,int b){
		return a*10 + b;
	}
	
	static void productTest(int i,int a ,int b){
		if(i==a*b){
			System.out.println( i + " = " + a + " * " + b);
		}
	}
	public static void main(String[] args) {
		for(int i = 1001; i < 9999; i++) {			
			productTest(i, com(a(i), b(i)), com(c(i), d(i)));
			productTest(i, com(a(i), b(i)), com(d(i), c(i)));
			productTest(i, com(a(i), c(i)), com(b(i), d(i)));
			productTest(i, com(a(i), c(i)), com(d(i), b(i)));
			productTest(i, com(a(i), d(i)), com(b(i), c(i)));
			productTest(i, com(a(i), d(i)), com(c(i), b(i)));
			productTest(i, com(b(i), a(i)), com(c(i), d(i)));
			productTest(i, com(b(i), a(i)), com(d(i), c(i)));
			productTest(i, com(b(i), c(i)), com(d(i), a(i)));
			productTest(i, com(b(i), d(i)), com(c(i), a(i)));
			productTest(i, com(c(i), a(i)), com(d(i), b(i)));
			productTest(i, com(c(i), b(i)), com(d(i), a(i)));
		}			
	}
}
