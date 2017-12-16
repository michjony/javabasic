package com.michjony.basic.thinkingjava.typeinfo;

import java.lang.reflect.Field;

/**
 * 反射访问私有域
 */
public class ModifyingPrivateFields {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		WithPrivateField pf = new WithPrivateField();
		System.out.println(pf);
		
		Field f = pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		int int1 = f.getInt(pf);
		System.out.println("f.getInt(pf) : " + int1);
		//通过反射方法设置私有属性
		f.setInt(pf, 2);
		System.out.println(pf);
		Field s = pf.getClass().getDeclaredField("s");
		s.setAccessible(true);
		System.out.println("s.get(pf) : " +  s.get(pf));
		//对于final修饰的属性的设值是无效的，编译及运行时，均不会抛出异常
		s.set(pf, "I'm not totally safe");
		System.out.println(pf);
		Field s2 = pf.getClass().getDeclaredField("s2");
		s2.setAccessible(true);
		System.out.println("s2.get(pf) : " +  s2.get(pf));
		//可以对私有的String属性进行修改，但是原始的字符串依然存在与常量池中。
		s2.set(pf, "No, you are not safe");
		System.out.println(pf);
	}
}

class WithPrivateField {
	private int i;
	private final String s = "I'm totally safe";
	private String s2 = "Am I safe";

	@Override
	public String toString() {
		return "WithPrivateField [i=" + i + ", s=" + s + ", s2=" + s2 + "]";
	}

}