package com.michjony.basic.thinkingjava.generics;

import java.util.HashMap;

/**
 * 泛型方法
 * @author Mark
 * @since 2017年12月17日 上午11:20:45
 */
public class GenericMethods {

	public <T> void fun(T t){
		System.out.println(t.getClass().getName());
	}
	
	public <T,U,V>  void fun(T t ,U u,V v){
		System.out.println(t.getClass().getSimpleName() + " " + u.getClass().getSimpleName() + " " + v.getClass().getSimpleName());
	}
	
	public <T,U>  void fun(T t ,U u,String str){
		System.out.println(t.getClass().getSimpleName() + " " + u.getClass().getSimpleName() + " " + str);
	}
	
	public static void main(String[] args) {
		GenericMethods method = new GenericMethods();
		method.fun("123");
		method.fun(123);
		method.fun(new HashMap<String,String>());
		method.fun(method);
		method.fun("123", 123, method);
		method.fun("123", 123, "123");
	}
}
