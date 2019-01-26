package com.bjpowernode.ba01;

public class Student {
	
	private String name;
	private int age;
	
	
	
	public Student() {
		super();
		System.out.println("myStudent的无参数构造方法");
	}
	public void setName(String name) {
		System.out.println("setName:"+name);
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("setAge:"+age);
		this.age = age;
	}
	
	public void setSex(String sex){
		System.out.println("setSex:"+sex);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	

}
