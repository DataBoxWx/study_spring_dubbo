package com.bjpowernode.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba01/applicationContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		
		//从spring获取aspectj修改的目标对象，就是代理对象
		SomeService service  = (SomeService) ctx.getBean("someServiceTarget");
		
		//目标对象有接口，默认使用jdk的动态代理 com.sun.proxy.$Proxy6
		System.out.println("service:"+service.getClass().getName());
		
		service.doSome();
		
	}
	
	
}
