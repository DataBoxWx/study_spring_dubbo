package com.bjpowernode.ba04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;

/**
 * @Aspect: 表示当前类是切面类。
 * 切面类是用来给其他业务方法增强功能的。
 * 
 * 位置：在类的上面
 *
 */
@Aspect
//@Scope(value="prototype")
public class MyAspect {
	//定义方法，实现功能增强。 切面类中定义的方法叫做通知方法。
	
	/**
	 * 异常通知： @AfterThrowing
	 *   属性： 1）value 切入点表达式
	 *        2）throwing 自定义的变量，表示目标方法抛出的异常， 必须和通知方法的Throwable类型的参数名名称一样
	 *   位置：方法的上面
	 * 特点：
	 * 1.在目标方法抛出异常时执行的。
	 * 2.不是异常处理程序， 异常还是被抛出的。
	 */
	@AfterThrowing(value="execution(* *..SomeServiceImpl.doSecond(..))",throwing="ex")
	public void myAfterThrowing(Throwable ex){
		//对异常做通知，通知给开发人员， 让他们处理异常情况。
		//发送邮件，短信给开发人员
		//记录到数据库，日志文件。
		System.out.println("异常通知：在目标方法抛出异常时执行的，ex："+ex.getMessage());
	}
}
