package com.bjpowernode.ba02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


	@Test
	public void test01(){
		String configLocation="com/bjpowernode/ba02/applicationContext.xml";
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		
		//从spring获取aspectj修改的目标对象，就是代理对象
		SomeService service  = (SomeService) ctx.getBean("someServiceTarget");
		
		/*String str = service.doOther();
		System.out.println("目标方法的最终调用结果："+str);*/
		
		Student student= service.doOther2();
		System.out.println("目标方法的最终调用结果:"+student);
		
	}
	
	
}
