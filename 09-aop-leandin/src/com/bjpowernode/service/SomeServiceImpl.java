package com.bjpowernode.service;

import com.bjpowernode.utils.ServiceTools;

public class SomeServiceImpl implements SomeService {

	@Override
	public void doSome() {
		ServiceTools.doLog();
		System.out.println("业务方法doSome()");
		ServiceTools.doTranaction();
	}

	@Override
	public void doOther() {
		ServiceTools.doLog();
		System.out.println("业务方法doOther()");
		ServiceTools.doTranaction();
	}

	
}
