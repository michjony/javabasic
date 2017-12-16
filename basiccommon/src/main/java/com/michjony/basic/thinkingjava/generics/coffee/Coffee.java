package com.michjony.basic.thinkingjava.generics.coffee;

public class Coffee {

	private static int count = 0;
	//final 修饰属性，表示属性【只能赋值一次】，（1）基本类型：值不能被修改；（2）引用类型：引用不可以被修改。是属于对象的变量。
	private final long id = count++;

	private static int si = 0;
	//final static 修饰成员变量 ， 属于类的变量且只能赋值一次
	private final static long fsl = si++;

	public String toString() {
		return this.getClass().getSimpleName() + " " + id + " --- fsl " + fsl;
	}

}
