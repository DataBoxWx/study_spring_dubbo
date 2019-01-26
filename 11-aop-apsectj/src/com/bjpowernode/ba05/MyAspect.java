package com.bjpowernode.ba05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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
public class MyAspect {
	//定义方法，实现功能增强。 切面类中定义的方法叫做通知方法。
	
	/**
	 * 最终通知： @After
	 *    属性： value 切入点表达式
	 *    位置： 方法的上面
	 *    
	 * 特点：
	 * 1.在目标方法之后执行的。
	 * 2.总是会被执行的。
	 * 
	 * try{
	 *    SomeServiceImpl.doThird()
	 * }finally{
	 *    myAfter()
	 * }
	 */
	@After(value="execution(* *..SomeServiceImpl.doThird(..))")
	public void myAfter(){
		//做资源回收，内存释放
		System.out.println("最终通知：在目标方法之后执行的");
	}
}
