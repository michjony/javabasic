package com.michjony.basic.thinkingjava.generics.coffee;

import java.util.Iterator;
import java.util.Random;

import com.michjony.basic.util.Generator;

/**
 * 咖啡生成器
 * <B>thinking java</B><BR>
 * <B>generics</B><BR>
 * <B>咖啡生成器</B><BR>
 * <B>随机生成不同类型的Coffee对象</B><BR>
 * @author mark
 * @since 2017年12月16日 下午9:53:18
 */
public class CoffeeGenerator implements Generator<Coffee> ,Iterable<Coffee> {

	//去除警告  rawtypes是说传参时也要传递带泛型的参数
	@SuppressWarnings("rawtypes")
	private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Breve.class, Americano.class };
	
	private static Random rand = new Random(47);
	
	public CoffeeGenerator(){}
	
	// for iter
	private int size = 0;
	public CoffeeGenerator(int sz){
		size = sz;
	}
	
	/*
	 * 返回一种咖啡 
	 */
	@Override
	public Coffee next() {
		try {
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			//抛出的运行时异常 不用在方法名后面增加抛出异常代码说明
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	
	/*
	 * 迭代器模式
	 */
	class CoffeeIterator implements Iterator<Coffee>{

		int count = size ; 
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count -- ;
			return CoffeeGenerator.this.next();
		}
		
	}

	public static void main(String[] args) {
		CoffeeGenerator cg = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(cg.next());
		}
		
		for (Coffee c : new CoffeeGenerator(5) ) {
			System.out.println(c);
		}
	}
}
