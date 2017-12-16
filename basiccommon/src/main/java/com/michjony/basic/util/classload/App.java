package com.michjony.basic.util.classload;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		//String引用的是bootstrap classloader的加载器
		System.out.println(String.class.getClassLoader());
		System.out.println(App.class.getClassLoader());
		System.out.println(App.class.getClassLoader().getParent().getClass().getClassLoader());
		System.out.println("=======");
		loadHello();
		//重新加载一个新的类
		System.gc(); //释放资源
		TimeUnit.SECONDS.sleep(2);
		String str = "G:\\develop-utils\\STSworkspace\\javabasic\\basiccommon\\target\\classes\\com\\michjony\\basic\\util\\classload\\FindDemo.class";
		File old = new File(str);
		old.delete();
		File nee = new File("2");
		nee.renameTo(old);
		loadHello();
	}
	
	public static void loadHello() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		MyClassLoader loader = new MyClassLoader();
		Class<?> clazz = loader.findClass("com.michjony.basic.util.classload.FindDemo");
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("say");
		method.invoke(obj);
		System.out.println(obj.getClass()+" " + obj.getClass().getClassLoader());
	}
}
