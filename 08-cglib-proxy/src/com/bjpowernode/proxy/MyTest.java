package com.bjpowernode.proxy;

import com.bjpowernode.service.SomeService;

public class MyTest {

	public static void main(String[] args) {

		SomeService target = new SomeService();
		
		ProxyFactory factory  =new ProxyFactory();
		
		SomeService proxy  = (SomeService) factory.createProxy(target);
		//代理对象的类型
		System.out.println("proxy:"+proxy.getClass().getName());
		
		String str  = proxy.doSome();
		System.out.println("cglib代理的执行结果："+str);

	}

}
