package com.bjpowernode.ba02;

public class Student {
	
	private String name;
	private int age;
	
	//引用类型
	private School mySchool;

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
	
	public void setMySchool(School mySchool) {
		System.out.println("setMySchool:"+mySchool);
		this.mySchool = mySchool;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mySchool=" + mySchool + "]";
	}

	

}
