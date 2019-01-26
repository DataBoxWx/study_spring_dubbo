package com.bjpowernode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.bjpowernode.utils.ServiceTools;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}


	public MyInvocationHandler() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override  //Method doSome doOther
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result  = null;
		
		//获取到执行的方法名称
		String methodName  = method.getName();
		
		
		if("doSome".equals(methodName)){ // 切入点 位置
			//在目标方法执行之前， 加入日志
			ServiceTools.doLog();
			//调用目标方法
			result = method.invoke(target, args);
			//在目标方法之后，加入事务
			ServiceTools.doTranaction();
		} else {
			//doOther  连接点 
			//调用目标方法
			result = method.invoke(target, args);
		}
		
		
		return result;
	}

}
