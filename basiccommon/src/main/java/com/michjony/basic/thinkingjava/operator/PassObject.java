package com.michjony.basic.thinkingjava.operator;

public class PassObject {
	//传递可变对象会可能会被方法篡改
	//对一个对象参数加final修饰是无效的，这个对象指向的内容依然会被修改，只是这个对象的引用无法被重新赋予新的对象引用
	static void f(final Letter y){
		y.c = 'c';
		//y = new Letter();
	}
	public static void main(String[] args) {
		Letter letter = new Letter();
		letter.c = 'a';
		System.out.println(letter.c);
		f(letter);
		System.out.println(letter.c);
	}
}

class Letter{
	char c ;
}