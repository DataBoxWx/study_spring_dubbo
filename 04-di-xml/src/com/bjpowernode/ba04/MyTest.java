package com.bjpowernode.ba04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba04/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		MyCollections myCollections  = (MyCollections) ctx.getBean("myCollections");
		System.out.println("myCollections:" + myCollections);
	}
	
}
