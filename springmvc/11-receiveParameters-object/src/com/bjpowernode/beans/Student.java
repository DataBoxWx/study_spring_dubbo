package com.bjpowernode.beans;

import org.springframework.web.bind.annotation.RequestParam;

public class Student {


	private String name;
	private Integer age;
	
	
	
	public Student() {
		super();
		System.out.println("student的无参数构造方法");
	}
	public void setName(String name) {
		System.out.println("setName:"+name);
		this.name = name;
	}
	public void setAge(Integer age) {
		System.out.println("setAge:"+age);
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}
