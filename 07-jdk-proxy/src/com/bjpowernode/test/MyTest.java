package com.bjpowernode.test;

import java.lang.reflect.Proxy;

import com.bjpowernode.proxy.MyInvocationHandler;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.SomeServiceImpl;

public class MyTest {

	public static void main(String[] args) {
		//创建代理对象
		
		//目标类对象
		SomeService target  = new SomeServiceImpl();
		//创建调用处理器对象
		MyInvocationHandler handler = new MyInvocationHandler(target);
		
		//创建代理对象
		SomeService proxy  = (SomeService) Proxy.newProxyInstance(
								target.getClass().getClassLoader(),
								target.getClass().getInterfaces(), 
								handler);
		System.out.println("proxy:"+proxy.getClass().getName());
		//调用代理对象的方法，实现功能增强
		String str  = proxy.doSome();
		System.out.println("通过代理执行目标方法的结果："+str);
		
	}

}
