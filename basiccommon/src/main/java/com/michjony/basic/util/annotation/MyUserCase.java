package com.michjony.basic.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * id 和 description 称为这个注解MyUserCase的元素
 * 注解的元素可用的类型是：
 * 基本类型 , String,Class,enum,Annotation 及这些类型的数组
* @ClassName: MyUserCase 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Michael-jony 
* @date 2017年4月15日 下午2:51:15 
*
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyUserCase {
	int id();
	String description() default "this is user case annotation" ;
}
