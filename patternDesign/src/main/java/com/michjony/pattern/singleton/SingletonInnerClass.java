package com.michjony.pattern.singleton;

public class SingletonInnerClass {
	
	private SingletonInnerClass(){}
	
	//静态内部类初始化单例对象
	private static class SingletonHolder{
		private static SingletonInnerClass singleton = new SingletonInnerClass();
	}
	
	//第一次调用时，才会去调用静态内部类初始化单例
	public static  SingletonInnerClass getSingleton(){
		return SingletonHolder.singleton;
	}
}
