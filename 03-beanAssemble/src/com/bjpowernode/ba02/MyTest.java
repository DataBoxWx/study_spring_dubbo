package com.bjpowernode.ba02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyTest {

	
	/**
	 * 单例对象是在什么时间创建的？
	 *  创建容器对象的时候，会创建单例对象
	 * 
	 */
	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba02/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		SomeService service1 = (SomeService) ctx.getBean("someService");
		SomeService service2 = (SomeService) ctx.getBean("someService");
		
		if( service1 == service2 ){
			System.out.println("service1 和 service2 是同一个对象");
		} else {
			System.out.println("service1 和 service2  不是   同一个对象");
		}
		
	}
	
	/**
	 * 原型作用域
	 * 原型作用域的对象创建时间？
	 * 在调用getBean()才创建对象， 原型作用域是把对象的创建时间延迟到使用对象的时候。
	 * 这种方式占用内存小，但是获取对象的速度慢。
	 */
	@Test
	public void test02(){
		String configLocation="com/bjpowernode/ba02/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		SomeService service1 = (SomeService) ctx.getBean("someService");
		SomeService service2 = (SomeService) ctx.getBean("someService");
		/*
		if( service1 == service2 ){
			System.out.println("service1 和 service2 是同一个对象");
		} else {
			System.out.println("service1 和 service2  不是   同一个对象");
		}*/
		
	}
	
	
}
