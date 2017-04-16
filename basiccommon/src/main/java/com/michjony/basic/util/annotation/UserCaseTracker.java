package com.michjony.basic.util.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * MyUserCase的注解处理器
* @ClassName: UserCaseTracker 
* @Description:MyUserCase的注解处理器
* @author Michael-jony 
* @date 2017年4月15日 下午2:23:02 
*
 */
public class UserCaseTracker {

	private static final Logger LOGGER = Logger.getLogger(UserCaseTracker.class.getName());  
	/**
	 * 
	* @Title: trackUserCases 
	* @Description: 使用反射机制查找MyUserCase注解
	* @param @param userCases
	* @param @param clazz   
	* @return void   
	* @throws
	 */
	public static void trackUserCases(List<Integer> userCases,Class<?> clazz){
		for (Method method : clazz.getDeclaredMethods()) {
			LOGGER.info("method name :"+method.getName());
			MyUserCase userCase = method.getAnnotation(MyUserCase.class);
			if(null != userCase){
				LOGGER.info("userCase id: " + userCase.id() + ";description:" + userCase.description());
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println(UserCaseTracker.class.getName());
		trackUserCases(Arrays.asList(1,2,3,4),UserUtils.class);
	}
}
