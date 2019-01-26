package com.bjpowernode.ba04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component: 创建类的对象， 默认是单例对象。
 *    属性： value ,表示对象的名称， 也就是<bean>的id值。
 *    位置： 在类的上面
 * 
 */
//省略value
@Component("myStudent")
public class Student {
	/**
	 * @Value:简单类型的属性赋值
	 *    属性：value ,简单类型的属性值
	 *    位置：
	 *      1.在属性定义上面，无需set方法。 推荐使用。
	 *      2.在set方法的上面
	 */
	@Value(value="张三")
	private String name;
	private int age;
	
	/**
	 * 引用类型
	 * @Autowired: spring框架提供的，引用类型赋值的注解。
	 *             @Autowired支持自动注入byName, byType. 默认是byType.
	 *       位置：
	 *          1.在属性定义的上面， 无需set方法， 常用方式
	 *          2.在set方法的上面
	 * 
	 *  byName自动注入，需要使用两个注解
	 *  1.@Autowired
	 *  2.@Qualifier(value="bean的id")
	 *          
	 *   
	 */
	//byName
	@Autowired
	@Qualifier(value="myXueXiao")
	private School mySchool;
	
	public Student() {
		super();
		System.out.println("myStudent的无参数构造方法");
	}
	public void setName(String name) {
		System.out.println("setName:"+name);
		this.name = name;
	}
	
	@Value(value="22")
	public void setAge(int age) {
		System.out.println("setAge:"+age);
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mySchool=" + mySchool + "]";
	}
	
	
	
	

}
