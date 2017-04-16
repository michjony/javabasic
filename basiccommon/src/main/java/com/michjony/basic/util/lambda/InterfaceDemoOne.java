package com.michjony.basic.util.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * fork from https://github.com/winterbe/java8-tutorial
* @ClassName: InterfaceDemoOne 
* @author Michael-jony 
* @date 2017年4月16日 下午2:25:04 
*
 */
public class InterfaceDemoOne {
	
	interface Formula  {
		//abstract method
		double calculate(int a);
		
		//default method
		default double sqrt(int a){
			return Math.sqrt(a);
		}
	}
	
	//
	public void demo1(){
		//f 是一个实现了Formula接口的匿名对象
		Formula f = new Formula(){
			@Override
			public double calculate(int a) {
				return sqrt(a*100);
			}};
		f.calculate(10);
		f.sqrt(10);
	}
	
	//使用匿名内部类
	public void demo2(){
		List<String> names = Arrays.asList("peter","anna","mike","xenia");
		names.stream().forEach(System.out::println);
		System.out.println("====");
		Collections.sort(names,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		names.stream().forEach(System.out::println);
		System.out.println("-----");
	}
	
	//使用lambda表达式
	public void demo3(){
		List<String> names = Arrays.asList("peter","anna","mike","xenia");
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		Collections.sort(names, (a,b)->b.compareTo(a));
	}
	
	
	public static void main(String[] args) {
		new InterfaceDemoOne().demo2();
		new InterfaceDemoOne().demo3();
	}
}
