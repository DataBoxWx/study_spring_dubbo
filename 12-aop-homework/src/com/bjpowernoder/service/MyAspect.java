package com.bjpowernoder.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	@Around(value="myPect()")
	public Object checkValue(ProceedingJoinPoint jp) throws Throwable{
		
		//System.out.println("沒勁");
		Object result = jp.proceed();
		Object[] args = jp.getArgs();
		for (Object arg : args) {
			if(arg == null || (int)arg <= 0){
				
				return null;
			}
			//result += (int)arg;
		}
		
		System.out.println("执行了相加方法");
		
		return result;
	}
	
	@Pointcut("execution(public * com.bjpowernoder.service.NumberServiceImpl.addNumber(..))")
	public void myPect(){
		
	}
}
