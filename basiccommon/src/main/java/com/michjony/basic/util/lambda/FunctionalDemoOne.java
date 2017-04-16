package com.michjony.basic.util.lambda;

/**
 * fork from https://github.com/winterbe/java8-tutorial#lambda-expressions
* @ClassName: FunctionalDemoOne 
* @Description: 
* @author Michael-jony 
* @date 2017年4月16日 下午9:39:23 
*
 */
public class FunctionalDemoOne {
	public static void main(String[] args) {
		 new FunctionalDemoOne().demo1();
		 new FunctionalDemoOne().demo2();
		 new FunctionalDemoOne().demo3();
		 new FunctionalDemoOne().demo4();
	}
	
	public void demo1(){
		System.out.println("===demo1===");
		//Converter 接口只有一个抽象方法，下面这行代码默认实现这个抽象方法
		Converter<String, Integer> converter = from -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
	}
	
	//Method and Constructor References
	//static method references
	public void demo2(){
		System.out.println("===demo2===");
		//::关键字传递方法或构造函数的引用  将valueOf方法赋予Converter接口的抽象方法convert
		Converter<String,Integer> converter = Integer::valueOf;
		Integer convert = converter.convert("1234");
		System.out.println(convert);
	}
	
	//reference object methods
	public void demo3(){
		System.out.println("===demo3===");
		Something sm = new Something();
		//将Something的startWith方法赋予Converter接口的抽象方法convert
		Converter<String,String> converter = sm::startWith;
		String convert = converter.convert("Michael");
		System.out.println(convert);
	}
	
	// reference to the Person constructor 
	public void demo4(){
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);
	}
}

class Something{
	String startWith(String s){
		return s.valueOf(s.charAt(0));
	}
}