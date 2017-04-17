package com.michjony.basic.util.lambda;

//从lambda表达式访问外部范围变量非常类似于匿名对象。 您可以从本地外部范围以及实例字段和静态变量访问最终变量。
public class LambdaScopeDemo {

//	Accessing local variables
	public void demo1(){
//		final int num = 1;
		int num = 1;
		Converter<Integer , String> stringConverter = (from)->String.valueOf(from + num) ;
		System.out.println(stringConverter.convert(1));
	}
	
	public void demo2(){
		int num = 1;
		Converter<Integer, String> stringConverter =
		        (from) -> String.valueOf(from + num);
//		num = 3;
	}
	
	
	//Accessing fields and static variables
	static int outerStaticNum;
	int outerNum;
	
	public void demo3(){
		Converter<Integer,String> stringConverter = (from) ->{ 
			outerStaticNum = 10 ;
			return String.valueOf(outerStaticNum+from);
		};
		System.out.println(stringConverter.convert(10));
		System.out.println("============");
		Converter<Integer,String> strConverter = from -> {
			outerNum = 5;
			return String.valueOf(outerNum + from  );
		};
		System.out.println(strConverter.convert(10));
	}
	
	//Accessing Default Interface Methods
//	Default methods cannot be accessed from within lambda expressions. 
	
	
	
	
	public static void main(String[] args) {
		new LambdaScopeDemo().demo3();
	}
}
