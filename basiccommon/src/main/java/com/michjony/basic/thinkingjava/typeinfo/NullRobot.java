package com.michjony.basic.thinkingjava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

import com.michjony.basic.util.Null;

/**
 *	对每一种Robot创建一个空对象 ，执行某些特殊操作
 *	提供空对象所代表的Robot确切类型的信息，这些信息通过动态代理捕获
 */
public class NullRobot {

	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), 
				new Class[] { Null.class, Robot.class },
				new NullRobotProxyHandler(type));
	}

	public static void main(String[] args) {
		Robot newNullRobot = newNullRobot(SnowRemovalRobot.class);
		Robot.Test.test(newNullRobot);
	}
}

/**
 * jdk动态代理 实现InvocationHandler接口
 * 动态地创建代理，并动态处理对所代理方法的调用，在动态代理上所做的所有调用都会被重定向到单一的调用处理器上
 */
class NullRobotProxyHandler implements InvocationHandler{

	private String nullName;
	
	private Robot proxied = new NRoot();
	
	/**
	 * 参数使用实现类对象
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
	
	NullRobotProxyHandler(Class<? extends Robot> type){
		nullName = type.getSimpleName() + " NullRoot";
	}
	
	
	private class NRoot implements Null,Robot{

		@Override
		public String name() {
			return nullName;
		}

		@Override
		public String model() {
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			return Collections.emptyList();
		}
		
	}
	
	
}
