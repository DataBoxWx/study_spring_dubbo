package com.bjpowernode.ba08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba08/applicationContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		Student myStudent = (Student) ctx.getBean("myStudent");
		System.out.println("student:"+myStudent);
		//执行销毁方法1.关闭容器；2.对象是单例的
		((ClassPathXmlApplicationContext)ctx).close();
	}
	
	
}
