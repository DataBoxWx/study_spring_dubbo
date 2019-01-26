package com.bjpowernode.ba03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba03/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		SomeService service = (SomeService) ctx.getBean("someService");
		service.doSome();
		
		/***
		 * SomeService service = new SomeServiceImpl();
		 * service.setUp();
		 * 
		 */
		
		
		/**
		 * 执行销毁方法
		 * 1.关闭容器
		 * 2.对象必须是单例的
		 */
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
	
	
	
}
