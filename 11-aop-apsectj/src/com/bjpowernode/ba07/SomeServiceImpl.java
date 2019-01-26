package com.bjpowernode.ba07;

public class SomeServiceImpl {


	public void doSome() {
		System.out.println("====有接口的目标方法doSome====");
	}


	public String doOther() {
		System.out.println("====有接口的目标方法doOther====");
		return "abcd";
	}


	public Student doOther2() {
		System.out.println("====有接口的目标方法doOther2====");
		Student student = new Student();
		student.setAge(20);
		student.setName("李四");
		
		return student;
	}


	public String doFirst(int number) {
		System.out.println("====有接口的目标方法doFirst====");
		return "doFirst:"+number;
	}


	public void doSecond() {
		System.out.println("====有接口的目标方法doSecond====" + (10/0));
		
	}


	public void doThird() {
		System.out.println("====有接口的目标方法doThird====");
		
	}

}
