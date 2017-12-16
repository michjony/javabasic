package com.michjony.basic.thinkingjava.generics;

/**
 * 暂时不指定类型,等具体使用什么类型的时候，再决定类型 
 * 使用类型参数	T
 * 泛型类
 */
public class Holder3<T> {

	private T a;
	public Holder3(T a){
		this.a = a ;
	}
	public void set(T a){
		this.a = a ;
	}
	public T get(){
		return a ;
	}
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		//不需要强化转化，编译器已处理好
		Automobile automobile = h3.get();
		//h3.set("123");
		System.out.println(automobile);
	}
}
