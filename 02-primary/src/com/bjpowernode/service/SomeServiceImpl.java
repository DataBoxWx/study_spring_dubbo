
package com.bjpowernode.service;

public class SomeServiceImpl implements SomeService {

	
	public SomeServiceImpl() {
		super();
		System.out.println("SomeServiceImpl的无参数构造方法");
	}

	@Override
	public void doSome() {
		System.out.println("====******业务方法doSome()*****====");
		
	}

}
