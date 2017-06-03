package com.michjony.pattern.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		SingletonEnum instance1= SingletonEnum.INSTACE;
		Singleton instance = instance1.getInstance();
		SingletonEnum instance2 = SingletonEnum.INSTACE;
		Singleton instance3 = instance2.getInstance();
		System.out.println(instance == instance3);
		//instance 实例对象的hashcode都一致
		System.out.println(instance);
		System.out.println(instance3);
		
	}
}
