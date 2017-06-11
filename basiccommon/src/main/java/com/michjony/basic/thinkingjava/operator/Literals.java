package com.michjony.basic.thinkingjava.operator;

public class Literals {

	
	
	public static void main(String[] args) {
		int i1 = 0x2f; // 2*16 + 15
		System.out.println("i1 : " + Integer.toBinaryString(i1));
		System.out.println("-i1 : " + Integer.toBinaryString(-i1));
		System.out.println(i1&-i1);
		int i2 = 0X2F;
		System.out.println("i2 : " + Integer.toBinaryString(i2));
		int i3 = 0177; // 7 + 7*8 + 1*64
		System.out.println("i3 : " + Integer.toOctalString(i3));
		System.out.println("i3 : " + Integer.toBinaryString(i3));
		System.out.println("i3 : " + Integer.toHexString(i3));
		System.out.println("i3 : " + Integer.toUnsignedLong(i3));
		System.out.println("i3 : " + Integer.toUnsignedLong(i3));
		
		System.out.println("i1 : " + Integer.highestOneBit(i1));
		System.out.println("i1 : " + Integer.lowestOneBit(i1));
		
		long  n1 = 0x2F;
		long n2 = 0x3F;
		System.out.println("n1 : " + Long.toBinaryString(n1));
		System.out.println("n2 : " + Long.toBinaryString(n2));
		System.out.println(7 + 7*8 + 1*64);
		System.out.println(15 + 7*16);
		
		double v = Double.MAX_VALUE;
		System.out.println(v);
		float f = Float.MAX_VALUE;
		System.out.println(f);
		
		int a = 0xaa; 
		int b = 0x55; 
		System.out.println(Integer.toBinaryString(a));
		System.out.printf("%8s \n",Integer.toBinaryString(b));
		System.out.printf("%8s \n",Integer.toBinaryString(a&b));
		System.out.println(Integer.toBinaryString(a^b));
		System.out.println(Integer.toBinaryString(a|b));
		
	}
	
}
