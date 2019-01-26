package com.bjpowernode.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Aspect: 表示当前类是切面类。
 * 切面类是用来给其他业务方法增强功能的。
 * 
 * 位置：在类的上面
 *
 */
@Aspect
public class MyAspect {
	//定义方法，实现功能增强。 切面类中定义的方法叫做通知方法。
	
	/***
	 * @Before:前置通知
	 *   属性： value ,表示切入点表达式的
	 *   位置：在方法的上面
	 * 特点：
	 * 1.在目标方法之前先执行的。
	 * 2.不能改变目标方法的执行结果。
	 * 3.不能影响目标方法的执行顺序。
	 */
	@Before(value="execution(* com.bjpowernode.ba01.SomeServiceImpl.doSome())")
	public void myBefore(){
		//实现日志的打印功能。  切面的功能增强
		System.out.println("前置通知，实现在目标方法之前，打印日志");
	}
	
	/**
	 * JoinPoint:表示切入点（方法定义）信息的。
	 *           使用JoinPoint能够获取切入点方法的参数列表，方法的名称
	 * 注意：JoinPoint一定是方法的第一个参数
	 */
	@Before(value="execution(* *..SomeServiceImpl.do*(..))")
	public void myBefore2(JoinPoint jp){
		
		//切入点方法的定义信息
		System.out.println("方法的签名："+jp.getSignature());
		//切入点方法的参数列表
		Object args [] = jp.getArgs();
		System.out.println("切入点方法的参数个数："+args.length);
		//实现日志的打印功能。  切面的功能增强
		System.out.println("前置通知，实现在目标方法之前，打印日志");
	}
}
