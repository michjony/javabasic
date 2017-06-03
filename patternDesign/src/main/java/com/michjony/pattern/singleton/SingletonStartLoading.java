package com.michjony.pattern.singleton;

/*
 * 启动加载单例 
 */
public class SingletonStartLoading {
	
     private SingletonStartLoading(){ }
     
     private static final SingletonStartLoading sinleton = new SingletonStartLoading();
     
     public SingletonStartLoading getSingleton(){
    	 return sinleton ;
     }
}
