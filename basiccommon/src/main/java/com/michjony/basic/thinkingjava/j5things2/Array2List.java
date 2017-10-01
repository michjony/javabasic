package com.michjony.basic.thinkingjava.j5things2;

import java.util.Arrays;
import java.util.List;

public class Array2List {
	public static void main(String[] args) {
		System.out.println(args);
		//返回的List不可被修改
		List<String> argsList = Arrays.asList(args);
		System.out.println(argsList);
		//运行时错误
		argsList.add("add");
		System.out.println(argsList);
	}
}
