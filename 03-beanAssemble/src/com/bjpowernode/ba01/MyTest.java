package com.bjpowernode.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba01/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		SomeService service = (SomeService) ctx.getBean("someService");
		service.doSome();
	}
	
	
}
