package com.wkcto.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo-provider.xml");
		ctx.start();
				

	}

}
