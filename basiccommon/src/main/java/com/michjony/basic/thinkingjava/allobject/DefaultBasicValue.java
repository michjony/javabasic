package com.michjony.basic.thinkingjava.allobject;

/**
* @ClassName: DefaultBasicValue 
* @Description: 基本类型的默认值
* @author Michael-jony 
* @date 2017年6月10日 上午9:11:27 
* 1:\u0000 是char类型的默认值
 */
public class DefaultBasicValue {
	private boolean b;
	byte by ;
	char c;
	int i;
	short s ;
	double d;
	long l;
	float f;
	
	public void fun() {
		System.out.println(b);
		System.out.println(c);
		System.out.println(by);
		System.out.println(i);
		System.out.println(s);
		System.out.println(d);
		System.out.println(l);
		System.out.println(f);
		System.out.println(c == '\u0000' ? '+' : '-');
		System.out.println(c == ' ' ? '+': '-' );
	}
	
	public static void main(String[] args) {
		new DefaultBasicValue().fun();
	}
}
