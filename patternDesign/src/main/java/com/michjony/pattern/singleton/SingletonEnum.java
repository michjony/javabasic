package com.michjony.pattern.singleton;

public enum SingletonEnum {
	INSTACE;
	private Singleton instance;
	SingletonEnum(){
		instance = new Singleton();
	}
	public Singleton getInstance() {
		return instance;
	}
}

class Singleton{
	Singleton(){
		System.out.println("Singleton 实例化"); 
	}
} 