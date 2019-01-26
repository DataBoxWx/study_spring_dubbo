package com.bjpowernode.ba04;

public class Student {
	
	private String name;
	private int age;
	
	//引用类型
	private School mySchool;

	public Student() {
		super();
	}
	
	//定义有参数的构造方法， spring调用有参数构造方法创建对象，同时给属性赋值
	public Student(String myname , int myage, School myXueXiao){
		//给属性赋值
		this.name  = myname;
		this.age  = myage;
		this.mySchool = myXueXiao;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setMySchool(School mySchool) {
		this.mySchool = mySchool;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mySchool=" + mySchool + "]";
	}

	

}
