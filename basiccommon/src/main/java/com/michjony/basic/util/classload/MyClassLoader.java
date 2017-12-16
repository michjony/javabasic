package com.michjony.basic.util.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义classloader
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author Michael-jony
 * @since 2017年10月28日
 */
public class MyClassLoader extends ClassLoader{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
		InputStream is =this.getClass().getResourceAsStream(fileName);
		try {
			byte[] b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(fileName);
		
	}
}
