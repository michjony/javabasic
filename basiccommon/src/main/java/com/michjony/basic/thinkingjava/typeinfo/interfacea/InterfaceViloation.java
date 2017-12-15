package com.michjony.basic.thinkingjava.typeinfo.interfacea;

import java.util.logging.Level;
import java.util.logging.Logger;

class B implements A {

	public B() {}

	@Override
	public void f() {

	}
	

	public void g() {

	}

}

public class InterfaceViloation{
	
	private static final Logger logger = Logger.getLogger("InterfaceViloation");
	public static void main(String[] args) {
		A a = new B();
		a.f();
		//a.g(); 直接调用,编译错误 . 实际上a是可以调用这个方法的
		logger.log(Level.INFO, a.getClass().getSimpleName());
		// 需要将其转型为B之后，才能调用
		if (a instanceof B){
			((B) a).g();
		}
	}
}
