package com.michjony.basic.thinkingjava.operator;

public class Assignment {
	public static void main(String[] args) {
		Tank t1 = new Tank();
		t1.level = 1;
		Tank t2 = new Tank();
		t2.level = 2;
		System.out.println(t1.level + " ; " +t2.level);
		//将t2的指向的引用赋值给t1，即t1和t2都指向一个对象
		t1 = t2 ; 
		System.out.println(t1.level + " ; " +t2.level);
		//t1 与 t2 指向一个对象，修改一个值，则两个值都会变化
		t1.level = 3;
		System.out.println(t1.level + " ; " +t2.level);
	}
}

class Tank{
	int level;
}
