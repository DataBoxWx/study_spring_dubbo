package com.bjpowernode.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	 * @AfterReturning:后置通知：
	 *      属性：1）value 切入点表达式
	 *           2）returning 自定义的变量，表示目标方法的返回值。 必须和通知方法的参数名一样。
	 *      位置：方法的上面
	 *      
	 * 特点：
	 *  1.在目标方法执行之后执行的。
	 *  2.能够获取到目标方法的执行结果。
	 *    1）如果目标方法的执行结果是String和基本数据类型，不能改变他的值。
	 *    2）如果目标方法返回的是对象（不包括String）是可以改变对象的属性值。
	 *  3.不能影响目标方法的执行。
	 *  
	 *  Object result = doOther();
	 *  myAfterReturning(result);
	 */
	@AfterReturning(value="execution(* *..SomeServiceImpl.doOther(..))",returning="result")
	public void myAfterReturning(Object result){
		//修改目标方法的执行结果
		if( result != null){
			String str = (String)result;
			result =" Hello "  + str.toUpperCase();
			
		}
		System.out.println("后置通知，在目标方法之后执行的，能够获取到目标方法的执行结果："+result);
	}
	
	
	@AfterReturning(value="execution(* *..SomeServiceImpl.doOther2(..))",returning="result")
	public void myAfterReturning2(JoinPoint jp,Object result){
		System.out.println("切入点方法的名称："+jp.getSignature().getName());
		//修改目标方法的执行结果
		if( result != null){
			Student str = (Student)result;
			str.setAge(30);
			str.setName("张三");
			
		}
		System.out.println("后置通知，在目标方法之后执行的，能够获取到目标方法的执行结果："+result);
	}
}
