package com.bjpowernoder.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
	
	@Test
	public void test01(){
		String configLocation = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		NumberService numberService = (NumberService) ac.getBean("someService");
		Integer num = numberService.addNumber(1, 0, 3);
		System.out.println(num);
		
	}
}
