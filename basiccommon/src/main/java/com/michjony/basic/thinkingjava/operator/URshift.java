package com.michjony.basic.thinkingjava.operator;

public class URshift {
	public static void main(String[] args) {
		int a = -1;
		System.out.printf("%32s\n", Integer.toBinaryString(a));
		a >>>= 10; //a无符号右移10位，高位补零
		System.out.printf("%32s\n", Integer.toBinaryString(a));
		long l = -1;
		System.out.printf("%64s\n", Long.toBinaryString(l));
		l >>>= 10;
		System.out.printf("%64s\n", Long.toBinaryString(l));
		short s=-1;
		System.out.printf("%32s\n", Integer.toBinaryString(s));
		System.out.printf("%32s\n", Integer.toBinaryString(s>>>10));
		s >>>= 10;
		System.out.printf("%32s\n", Integer.toBinaryString(s)); 
		byte b =-1;
		System.out.printf("%32s\n", Integer.toBinaryString(b)); 
		b >>>= 10;
		System.out.printf("%32s\n", Integer.toBinaryString(b));
		b = -1;
		System.out.printf("%32s\n", Integer.toBinaryString(b));
		System.out.printf("%32s\n", Integer.toBinaryString(b>>>10));
		System.out.println("1111111111111111111111".length()/4);
		System.out.println("11111111111111111111111111111111".length()/8);
	}
}
