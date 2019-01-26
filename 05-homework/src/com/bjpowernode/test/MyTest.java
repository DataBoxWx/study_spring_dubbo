package com.bjpowernode.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.service.UserService;

public class MyTest {

	@Test
	public void test01(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("myUserService");
		service.addUser();
	}
}
