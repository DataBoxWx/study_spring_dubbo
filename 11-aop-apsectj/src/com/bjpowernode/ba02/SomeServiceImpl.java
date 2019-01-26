package com.bjpowernode.ba02;

public class SomeServiceImpl implements SomeService {

	@Override
	public void doSome() {
		System.out.println("====有接口的目标方法doSome====");
	}

	@Override
	public String doOther() {
		System.out.println("====有接口的目标方法doOther====");
		return "abcd";
	}

	@Override
	public Student doOther2() {
		System.out.println("====有接口的目标方法doOther2====");
		Student student = new Student();
		student.setAge(20);
		student.setName("李四");
		
		return student;
	}

}
