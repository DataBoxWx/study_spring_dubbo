package com.bjpowernode.ba01;

import org.springframework.stereotype.Component;

/**
 * @Component: 创建类的对象， 默认是单例对象。
 *    属性： value ,表示对象的名称， 也就是<bean>的id值。
 *    位置： 在类的上面
 * @Component(value="myStudent")等价于
 * <bean id="myStudent" class="com.bjpowernode.ba01.Student" />
 * 
 * 创建对象的其他三个注解
 * 1.@Repository:放在Dao层实现类的上面，创建Dao对象
 * 2.@Service:放在Service层的实现类上面，创建Service对象
 * 3.@Controller:放在处理器类的上面， 创建处理器对象（类似Servlet）。
 * 
 */
//使用value指定对象的名称
//@Component(value="myStudent")

//省略value
@Component("myStudent")

//不指定对象名称， 由框架赋予默认值: 类名的首字母小写
//@Component
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
