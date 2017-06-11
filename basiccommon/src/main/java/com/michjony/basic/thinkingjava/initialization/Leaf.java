package com.michjony.basic.thinkingjava.initialization;

public class Leaf {

	int i = 0 ;
	
	//通过this返回当前对象的引用
	Leaf increment(){
		 i++;
		 return this;
	}
	
	void print(){
		System.out.println("i : "+ i);
	}
	public static void main(String[] args) {
		Leaf a = new Leaf();
		a.increment().increment().print();
	}
}
