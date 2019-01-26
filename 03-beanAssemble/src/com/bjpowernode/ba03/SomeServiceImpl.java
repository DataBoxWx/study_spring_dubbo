
package com.bjpowernode.ba03;

public class SomeServiceImpl implements SomeService {

	//spring默认是调用类的无参数构造方法，创建对象
	public SomeServiceImpl() {
		System.out.println("SomeServiceImpl的无参数构造方法");
	}

	@Override
	public void doSome() {
		System.out.println("====******业务方法doSome()*****====");
	}
	
	//定义bean的生命始末方法。
	
	//定义bean初始化方法， 相当于构造方法的作用。
	public void setUp(){
		System.out.println("bean的初始化方法， 等同于构造方法的作用， 可以给属性赋值， 创建其他对象");
	}

	//定义bean的销毁方法，在对象销毁之前执行的方法。
	public void tearDown(){
		System.out.println("bean销毁之前执行的方法， 可以用来做资源回收， 释放内存等工作");
	}
}
