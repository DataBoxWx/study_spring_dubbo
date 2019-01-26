package com.bjpowernode.service;
//目标类
public class SomeServiceImpl implements SomeService {

	@Override
	public String doSome() {
		System.out.println("目标类的目标方法doSome()");
		return "abcd";
	}

}
