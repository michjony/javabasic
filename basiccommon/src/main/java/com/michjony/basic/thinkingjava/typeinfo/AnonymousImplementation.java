package com.michjony.basic.thinkingjava.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import com.michjony.basic.thinkingjava.typeinfo.interfacea.A;

/**
 * 使用反射访问匿名内部类 反射是基于运行时的class文件访问方法，与类的实现方式（接口实现类，内部类，匿名类）没有关系
 */
public class AnonymousImplementation {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		A a = AnnoymousA.makeA();
		a.f();
		HiddenImplementation.callHiddenMethod(a, "g");
	}
}

class AnnoymousA {

	private static Logger logger = Logger.getLogger("AnnoymousA");

	public static A makeA() {
		return new A() {

			@Override
			public void f() {
				logger.info("AnnoymousA-f");
			}

			@SuppressWarnings("unused")
			private void g() {
				logger.info("AnnoymousA-g");
			}
		};
	}
}
