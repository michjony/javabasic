package com.michjony.basic.util.lambda;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateDemoOne {
	//Predicate
	public void demo1(){
		Predicate<String> predicate = s->s.length()>0;
		boolean test1 = predicate.test("foo");
		boolean test2 = predicate.negate().test("foo");
		System.out.println(test1 + " -- " + test2);
		//lambda构造器  类的静态方法
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate<String> isEmpty = String::isEmpty;
		//调用谓词的默认方法default
		Predicate<String> isNotEmpty  = isEmpty.negate();
	}
	
	//Functions
//	Functions accept one argument and produce a result. Default methods can be used to chain multiple functions together (compose, andThen).
	public void demo2(){
		Function<String,Integer> toInteger = Integer::valueOf;
		Function<String,Integer> toInteger1 = (String i) -> {return  Integer.valueOf(i) ;};
		Function<String,Integer> toInteger2 = i -> Integer.valueOf(i) ;
		if( toInteger1.apply("1234") instanceof Integer){
			System.out.println("toInteger1 is integer");
		}
		System.out.println(toInteger1.apply("1234") );
		Function<String,String> backToString = toInteger.andThen(String::valueOf);
		String apply = backToString.apply("123");
		System.out.println(apply);
	}
	
	//Suppliers
//	Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.
	public void demo3(){
		//TODO
		
	}
	
	public static void main(String[] args) {
		new PredicateDemoOne().demo2();
	}
}
