package com.michjony.basic.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解知识点：
 * @Target 用于定义注解用在什么地方：类，方法，字段
 * @Retention 用于定义注解用在哪一个级别上面 
 * 没有元素的注解称为标记注解，此注解就是标记注解
* @ClassName: MyTestAnn 
* @Description: 注解示例类
* @author Michael-jony 
* @date 2017年4月15日 下午1:41:38 
* 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTestAnn {

}
