package com.michjony.basic.thinkingjava.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.michjony.basic.thinkingjava.typeinfo.interfacea.A;
import com.michjony.basic.thinkingjava.typeinfo.packageaccess.HiddenC;

public class HiddenImplementation {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		A a = HiddenC.markA();
		a.f();
		//使用反射依然可以访问对象的所有方法
		callHiddenMethod(a,"g");
		callHiddenMethod(a,"u");
		callHiddenMethod(a,"v");
		callHiddenMethod(a,"w");
	}

	static void callHiddenMethod(Object a,String method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method m = a.getClass().getDeclaredMethod(method);
		m.setAccessible(true);
		m.invoke(a);
	}
	
}
