package com.taxit.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory
{
	private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
	
	public static <T> T getBean(Class<T> clazz)
	{
		return context.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> expectedClass)
	{
		return context.getBean(name, expectedClass);
	}
}
