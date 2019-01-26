package com.bjpowernode.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.beans.Student;
import com.bjpowernode.service.StudentService;

public class MyTest {

	private StudentService service   = null;
	//junit的初始化方法
	@Before
	public void mySetup(){
		System.out.println("先执行@Before修饰的方法");
		String configLocation="applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		service = (StudentService) ctx.getBean("studentService");
		
	}
	
	@Test
	public  void testAddStudent(){
		
		Student student = new Student();
		student.setAge(30);
		student.setName("周丽");
		service.addStudent(student);
		System.out.println("addStudent");
	}
	
	@Test
	public void testQueryStudent(){
		List<Student> students = service.queryStudents();
		for(Student stu: students){
			System.out.println("stu:"+stu);
		}
	}
	
	@Test
	public void testContainer(){
		String configLocation="applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		String names [] = ctx.getBeanDefinitionNames();
		for(String name: names){
			System.out.println(name);
		}
	}
}
