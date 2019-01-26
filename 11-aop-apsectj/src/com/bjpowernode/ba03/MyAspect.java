package com.bjpowernode.ba03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
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
	
	/**
	 * 环绕通知：@Around
	 *   属性： value 表示切入点表达式
	 *   位置： 方法的上面
	 *   
	 * 特点：
	 *  1.在目标方法的前和后都能增强功能
	 *  2.控制目标方法的执行
	 *  3.能够修改目标方法的执行结果
	 * @throws Throwable 
	 */
	@Around(value="execution(* *..SomeServiceImpl.doFirst(..))")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{  // ProceedingJoinPoint = Method
		Object result = null;
		
		//获取切入点方法的签名
		System.out.println("方法的签名："+pjp.getSignature());
		Object args [] =pjp.getArgs();
		for(Object arg : args){
			System.out.println("arg："+arg);
		}
		
		System.out.println("环绕通知：在目标方法之前，增加日志功能");
		//控制目标方法的调用
		if( args.length > 0 ){
			//调用目标方法 Method.invoke();
			result  = pjp.proceed();
			
			//修改目标方法的执行结果
			if( result != null){
				result = "Hello AspectJ Around";
			}
		}
		System.out.println("环绕通知：在目标方法之后，增加事务处理");
		//返回目标方法的执行结果
		return result;
	}
}
