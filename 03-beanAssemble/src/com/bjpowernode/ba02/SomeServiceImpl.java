
package com.bjpowernode.ba02;

public class SomeServiceImpl implements SomeService {

	//spring默认是调用类的无参数构造方法，创建对象
	public SomeServiceImpl() {
		System.out.println("SomeServiceImpl的无参数构造方法");
	}

	@Override
	public void doSome() {
		System.out.println("====******业务方法doSome()*****====");
		
	}

}
