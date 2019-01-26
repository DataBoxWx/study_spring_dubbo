package com.bjpowernode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//调用处理器：实现功能增强和控制访问
public class MyInvocationHandler implements InvocationHandler {

	//目标对象
	private Object target;
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	public MyInvocationHandler() {
		super();
	}

	/**
	 * 能够截取对目标方法的调用。
	 * 参数：
	 *  Object proxy：jvm生成的代理对象
	 *  Method method：目标方法对象
	 *  Object[] args：目标方法的参数
	 * 返回值：
	 *  Object：目标方法的执行结果（可以是修改后的执行结果）
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("=============invoke==============");
		Object result = null;
		
		//调用目标方法
		result  = method.invoke(target, args); //doSome()
		
		System.out.println("目标方法执行之后， 提交事务");
		//对目标方法的执行结果做处理
		if(result != null){
			String str = (String)result;
			result  = str.toUpperCase();
		}
		// 目标方法的执行结果
		return result;
	}

}
