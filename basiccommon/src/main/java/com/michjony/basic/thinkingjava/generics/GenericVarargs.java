package com.michjony.basic.thinkingjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数与泛型方法
 * @author Mark
 * @since 2017年12月17日 下午12:17:10
 */
public class GenericVarargs {

	public static <T> List<T> makeList(T... args){
		List<T> list = new ArrayList<T>();
		for (T t : args) {
			list.add(t);
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(makeList("hello java".split(" ")));
	
	}
}
