package com.bjpowernode.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
// MethodInterceptor == InvocationHandler
public class MyMethodInceptor implements MethodInterceptor {

	private Object target = null;
	
	
	public MyMethodInceptor(Object target) {
		super();
		this.target = target;
	}

	public MyMethodInceptor() {
		super();
	}

	/**
	 * intercept = jdk中invoke()
	 * 
	 * 参数：
	 *   Object obj：代理对象
	 *   Method method：目标方法
	 *   Object[] args：方法的参数
	 *   MethodProxy proxy：方法的代理对象
	 * 返回值：
	 *   Object:目标方法的执行结果，可以是修改后的结果
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("===========intercept=========");
		Object result = null;
		//调用目标方法
		result = method.invoke(target, args);
		
		//修改目标方法的执行结果
		if( result != null) {
			String str = (String)result;
			result  = str.toUpperCase();
		}
		return result;
	}

	

}
