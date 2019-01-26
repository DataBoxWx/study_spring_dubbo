package com.bjpowernode.test;

import java.io.File;
import java.io.IOException;

import com.bjpowernode.Container;
import com.bjpowernode.service.UserService;

public class MyTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
		//创建Service对象， 调用它的方法。 现在创建java对象， 一般使用new 构造方法
		//UserService service = new UserServiceImpl();
		
		//service.addUser();
		
		//使用Container类对象，获取创建好的对象
		String path  = MyTest.class.getResource("/").getPath();
		System.out.println("path:"+path);
		File file = new File(path,"myobject.txt");
		//创建容器对象
		Container c  = new Container(file);
		//从容器中拿对象
		UserService service = (UserService) c.getBean("service");
		
		service.addUser();
		

	}

}
