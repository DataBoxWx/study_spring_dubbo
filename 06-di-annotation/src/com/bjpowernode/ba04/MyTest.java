package com.bjpowernode.ba04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba04/applicationContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		Student myStudent = (Student) ctx.getBean("myStudent");
		System.out.println("student:"+myStudent);
	}
	
	
}
