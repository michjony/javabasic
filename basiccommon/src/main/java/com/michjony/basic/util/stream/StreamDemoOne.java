package com.michjony.basic.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class StreamDemoOne {
	
	//创建Stream  使用Stream的静态方法
	public void demo1(){
//		1.使用of方法
		Stream<Integer> intStream = Stream.of(1,2,3,4);
		Stream<String> strStream = Stream.of("michjony zhao");
//		2.使用generator方法 生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
		//使用匿名内部类
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		//使用lambda表达式
		Stream.generate(()->Math.random());
		Stream.generate(Math::random);
		
//		3.iterate方法 生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的
//		先获取一个无限长度的正整数集合的Stream，然后取出前10个打印。千万记住使用limit方法，不然会无限打印
		Stream.iterate(1, item->item+1).limit(10).forEach(System.out::println);
	}
	
	//创建Stream  使用Collection的子类
	public void demo2(){
		
		List<String> list= new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		//使用Collection接口的stream方法
		Stream<String> stream = list.stream();
	}
	
	//转换Stream
//	转换Stream其实就是把一个Stream通过某些行为转换成一个新的Stream 
//	distinct ,filter ,map ,flatMap ,peek ,limit  ,skip 
	public void demo3(){
		List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//		给定一个Integer类型的List，获取其对应的Stream对象，然后进行过滤掉null，再去重，再每个元素乘以2，再每个元素被消费的时候打印自身，在跳过前两个元素，最后去前四个元素进行加和运算
		System.out.println(
				nums.stream()
				.filter(num->num!=null)
				.distinct()
				.mapToInt(num->num*2)
				.peek(System.out::println)
				.skip(2)
				.limit(4)
				.sum()
				);
	}
	
	
	//可变汇聚 它可以把Stream中的要有元素收集到一个结果容器中
	public void demo4() {
		List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//		 <R> R collect(Supplier<R> supplier,
//                 BiConsumer<R, ? super T> accumulator,
//                 BiConsumer<R, R> combiner);
		
		List<Integer> numsWithoutNull = nums.stream()
				.filter(num -> num != null)
				.collect(() -> new ArrayList<Integer>(), //第一个函数生成一个新的ArrayList实例；
//						第二个函数接受两个参数，第一个是前面生成的ArrayList对象，二个是stream中包含的元素，函数体就是把stream中的元素加入ArrayList对象中。第二个函数被反复调用直到原stream的元素被消费完毕
				(list, item) -> list.add(item),  // BiConsumer<R, ? super T>
//				第三个函数也是接受两个参数，这两个都是ArrayList类型的，函数体就是把第二个ArrayList全部加入到第一个中
				(list1, list2) -> list1.addAll(list2) // BiConsumer<R, R> combiner)
				);
	}
	
	//Optional<T> reduce(BinaryOperator<T> accumulator);
	public void demo5(){
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("ints sum is:" + 
				ints.stream()
//				reduce方法接受一个函数，这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），
//				第二个参数是stream中的元素，这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数。
//				Optional<T> reduce(BinaryOperator<T> accumulator);
				.reduce((sum, item) -> sum + item)
				.get());
	}
	
	//T reduce(T identity, BinaryOperator<T> accumulator);
//	它允许用户提供一个循环计算的初始值，如果Stream为空，就直接返回该值。而且这个方法不会返回Optional，因为其不会出现null值
	public void demo6(){
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("ints sum is:" + ints
				.stream()
				.reduce(0, (sum, item) -> sum + item));
	}
	
	
	
}
