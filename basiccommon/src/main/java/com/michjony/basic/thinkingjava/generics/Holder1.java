package com.michjony.basic.thinkingjava.generics;

/**
 * 持有一个Automobile对象的类
 */
public class Holder1 {
	private Automobile a ;
	public Holder1(Automobile a ){
		this.a = a;
	}
	Automobile get(){
		return a ;
	}
}

class Automobile{

	@Override
	public String toString() {
		return "Automobile []";
	}
	
}

