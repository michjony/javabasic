package com.michjony.basic.thinkingjava.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import com.michjony.basic.thinkingjava.typeinfo.interfacea.A;

/**
 * 使用反射访问私有内部类的私有方法
 */
public class InnerImplementation {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		A a = InnerA.markA();
		a.f();
		//使用反射依然可以访问内部类的私有方法
		HiddenImplementation.callHiddenMethod(a, "g");
	}
}

/**
 * 将接口实现为一个私有内部类
 * @since 2017年12月16日
 */
class InnerA {

	private static class C implements A {
		private static Logger logger = Logger.getLogger("C");

		@Override
		public void f() {
			logger.info("innerA class C.f()");
		}

		private void g() {
			logger.info("innerA class C.g()");
		}
	}

	public static A markA() {
		return new C();
	}

}