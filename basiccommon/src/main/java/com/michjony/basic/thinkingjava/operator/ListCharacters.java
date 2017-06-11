package com.michjony.basic.thinkingjava.operator;

import java.util.Random;

public class ListCharacters {
	public static void main(String[] args) {
		for (char i = 0; i < 128; i++) {
			if(Character.isLowerCase(i)){
				System.out.println( "Character : " + i  + ";value: " + (int)i );
			}
		}
		
		for(int i = 1; i < 10; i++ ) {
			int factors = 0;
			for(int j = 1; j < (i + 2)/2; j++ ) {
				if((i % j) == 0) factors++; 			
			}
			if(factors < 2) System.out.println(i + " is prime");
		}
		
		Random rand3 = new Random();
		Random rand4 = new Random();
		while(true) {
			//	TODO 增加控制台终止程序逻辑 
			int x = rand3.nextInt(10);
			int y = rand4.nextInt(10);
			if(x < y) System.out.println(x + " < " + y);
			else if(x > y) System.out.println(x + " > " + y);
			else System.out.println(x + " = " + y);
			break;
		}
		
		int i = 1 + 4 + 16 + 64;
		int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
		String stri = Integer.toBinaryString(i);
		System.out.printf("%32s\n",stri);
		int onecount = 0 ;
		char[] charArray = stri.toCharArray();
		for (int j = 0; j < charArray.length; j++) {
			if(charArray[j]== '1'){
				++onecount;
			}
		}
		System.out.println(numberOfLeadingZeros);
		System.out.println(onecount);
		
	}

}
