package com.michjony.basic.thinkingjava.typeinfo.packageaccess;

import java.util.logging.Logger;

import com.michjony.basic.thinkingjava.typeinfo.interfacea.A;

class C implements A {

	private static final Logger logger = Logger.getLogger("C");
	
	@Override
	public void f() {
		logger.info("public C.f()");
	}
	
	public void g(){
		logger.info("public C.g()");
	}
	
	void u(){
		logger.info("package C.u()");
	}
	
	protected void v(){
		logger.info("protected C.v()");
	}
	
	private void w(){
		logger.info("protected C.w()");
	}
	
	public static void main(String[] args) {
		C  c  = new C();
		c.f();
		c.g();
	}
	
	private void invokecurrentInfo(){
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String methodName = stackTrace[2].getMethodName();
		String className = stackTrace[2].getClassName();
		logger.info("current class: " + className);
		logger.info("current method: " + methodName);
	}
}


public class HiddenC {
	//即使从markA()返回的是C类型，在包的外部仍旧不能使用A之外的任何方法，因为不能在包的外部命名C
	public static A markA(){
		return new C();
	}
}
