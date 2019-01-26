package com.bjpowernode.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bjpowernode.service.SomeService;

public class MyTest {

	//在代码中创建spring的容器， 获取容器中对象。
	public static void main(String[] args) {
		//定义变量保存spring配置文件的位置
		//配置文件放在src目录，也就是代码编译后， 配置文件是放到了类路径(classpath)的根目录下
		String configLocation = "applicactionContext.xml";
		
		//创建spring的容器对象: 当配置文件放在类路径中，使用ClassPathXmlApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		
		//从spring的容器中获取对象，使用getBean("<bean>的id")
		SomeService service = (SomeService) ctx.getBean("someService");
		
		//调用对象的业务方法
		service.doSome();

	}
	
	/**
	 * spring配置文件放在磁盘的目录中， 
	 * 使用接口的FileSystemXmlAppliationContext ,读取磁盘的配置文件
	 */
	@Test
	public void test01(){
		String configLocation="D:\\data\\applicactionContext.xml";
		ApplicationContext ctx  = new FileSystemXmlApplicationContext(configLocation);
		SomeService service  = (SomeService) ctx.getBean("someService");
		service.doSome();
	}
	
	/**
	 * spring的配置文件放在项目的根目录下。
	 * 使用接口的FileSystemXmlAppliationContext ,读取项目根目录下的配置文件（此时只需提供文件名）
	 */
	@Test
	public void test02(){
		String configLocation="applicactionContext.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);
		//对象是存放到Map<String,Object> ，getBean()是从Map中获取对象
		SomeService service  = (SomeService) ctx.getBean("someService");
		service.doSome();
	}

	/**
	 * spring管理的java对象在什么时候创建的？
	 * 创建spring容器对象的同时，会读取spring配置文件，创建文件中的所有对象。
	 * 使用getBean()获取的是已经创建好的对象。
	 * 
	 * 优点： 获取对象的效率高。
	 * 缺点： 占用内存。
	 */
	@Test
	public void test03(){
		String configLocation="applicactionContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		SomeService service = (SomeService) ctx.getBean("someService");
		service.doSome();
	}
	
	/**
	 * 了解容器中内部的信息
	 */
	@Test
	public void test04(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicactionContext.xml");
		int counts  = ctx.getBeanDefinitionCount();
		System.out.println("容器中对象的个数："+counts);
		
		//获取容器中的对象所有名称
		String [] names  = ctx.getBeanDefinitionNames();
		for(String name: names){
			System.out.println("容器中对象的名称："+name);
		}
	}
	
}
