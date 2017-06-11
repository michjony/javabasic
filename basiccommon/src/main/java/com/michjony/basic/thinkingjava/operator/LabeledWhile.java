package com.michjony.basic.thinkingjava.operator;

public class LabeledWhile {
	public static void main(String[] args) {
		int i = 0;
		outer:

		while (true) {
			System.out.println("outer while loop");
			inner: while (true) {
				i++;
				System.out.println("i :" + i);
				if (i == 1) {
					System.out.println("continue"); 
					continue;//跳过下列代码逻辑，继续内层循环
				}
				if (i == 3) {
					System.out.println("continue outer");
					continue outer; //跳出内层循环，跳到外层outer循环
				}
				if (i == 5) {
					System.out.println("break inner");
					break inner; //中断内层循环，继续外层循环
				}
				if(i==7){
					break outer; //中断并跳出标签所指循环
				}
			}
		}
		System.out.println("over");
	}
}
