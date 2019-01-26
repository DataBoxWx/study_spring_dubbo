package com.bjpowernode.aop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

	@Before(value="execution(* com.bjpowernode.controllers.*.*(..))")
	public void recordLog(JoinPoint jp){
		StringBuffer buffer = new StringBuffer();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		buffer.append("log").append("|").append(df.format(new Date())).append("|");
		
		//加入参数
		Object args []  = jp.getArgs();
		for(Object arg : args){
			buffer.append(arg).append("|");
		}
		
		//记录StringBuffer到日志文件
		System.out.println("日志："+buffer.toString());
	}
}
