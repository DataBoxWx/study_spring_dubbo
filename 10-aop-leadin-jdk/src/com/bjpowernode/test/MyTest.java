package com.bjpowernode.test;

import java.lang.reflect.Proxy;

import com.bjpowernode.proxy.MyInvocationHandler;
import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.SomeServiceImpl;

public class MyTest {

	public static void main(String[] args) {
		
//		SomeService service = new SomeServiceImpl();
//		service.doSome();
//		System.out.println("===============================");
//		service.doOther();
		
		
		SomeService target  = new SomeServiceImpl();
		
		MyInvocationHandler h = new MyInvocationHandler(target);
		
		SomeService proxy = (SomeService) Proxy.newProxyInstance(
							target.getClass().getClassLoader(), 
							target.getClass().getInterfaces(), 
							h);
		
		//通过代理执行业务方法
		proxy.doSome();
		System.out.println("======================");
		proxy.doOther();

	}

}
