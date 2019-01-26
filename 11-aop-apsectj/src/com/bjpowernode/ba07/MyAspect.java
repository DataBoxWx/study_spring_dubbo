package com.bjpowernode.ba07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	@After(value="mypt()")
	public void myAfter(){
		//做资源回收，内存释放
		System.out.println("最终通知：在目标方法之后执行的");
	}
	
	@Before(value="mypt()")
	public void myBefore(){
		System.out.println("前置通知：在目标方法之前执行的");
	}
	
	/***
	 * @Pointcut: 管理切入点定义的。
	 *      属性： value 切入点表达式
	 *      位置：在一个定义的方法的上面， 方法的原型是 private void 方法名自定义的() { //无需代码的} 
	 *      
	 * 使用@Pointcut定义方法， 方法名相当于切入点的别名。 其他使用切入点的通知方法， value属性值可以使用方法名。
	 */
	@Pointcut(value="execution(* *..SomeServiceImpl.doThird(..))")
	private void mypt(){
		//无需代码的
	}
}
	
