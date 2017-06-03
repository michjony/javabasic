package com.michjony.pattern.singleton;

public class Singletonsynchronized {
	
	private static Singletonsynchronized singleton = null ;
	
	private Singletonsynchronized(){}
	
	//每次获取之前都要加锁，效率低下
	public static synchronized Singletonsynchronized getSingleton(){
		if(null == singleton){
			singleton = new Singletonsynchronized();
		}
		return singleton ;
	}
}
