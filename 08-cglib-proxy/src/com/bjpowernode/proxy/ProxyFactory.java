package com.bjpowernode.proxy;

import com.bjpowernode.service.SomeService;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

	public Object createProxy(Object target){
		//创建Enhancer对象
		Enhancer en = new Enhancer();
				
		//指定父类（目标类）
		en.setSuperclass(SomeService.class);
		
		//指定功能增强的方法拦截器
		en.setCallback(new MyMethodInceptor(target));
		
		//创建代理对象
		return en.create();
	}
}
