package com.bjpowernode.test;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.SomeServiceImpl;

public class MyTest {

	public static void main(String[] args) {
		
		SomeService service = new SomeServiceImpl();
		service.doSome();
		System.out.println("===============================");
		service.doOther();

	}

}
