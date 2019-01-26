package com.bjpowernode.ba02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba02/applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		Student myStudent = (Student) ctx.getBean("myStudent2");
		System.out.println("student:"+myStudent);
	}
	
	public void test02(){
		Student student = new Student();
		student.setAge(20);
		student.setName("李四");
		
		School school = new School();
		school.setAddress("北京");
		school.setName("北京大学");
		
		student.setMySchool(school);
	}
	
}
