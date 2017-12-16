package com.michjony.basic.util;

/**
 * 泛型接口
 * <B>thinking java</B><BR>
 * <B>generics</B><BR>
 * <B>生成器,工厂方法设计模式</B><BR>
 * <B>负责创建对象的类</B><BR>
 * @author Mark
 * @since 2017年12月16日 下午7:51:31
 * @see com.michjony.basic.thinkingjava.generics.coffee.CoffeeGenerator
 * @see com.michjony.basic.thinkingjava.generics.Fibonacci
 */
public interface Generator<T> {
	T next();
}
