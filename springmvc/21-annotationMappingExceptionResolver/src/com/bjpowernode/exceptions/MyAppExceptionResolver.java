package com.bjpowernode.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ControllerAdvice:处理器增强
 * 就是给处理器增强一些功能的，常增强的是异常处理。
 * 可以把@ExceptionHandler修饰的方法定义在此类中。 
 * 当处理器抛出异常时， 会调用处理器增强类的方法处理异常。
 *
 */
@ControllerAdvice
public class MyAppExceptionResolver {

	/**
	 * 定义方法处理异常。
	 * 处理异常方法定义和处理器方法的定义是一样。
	 */
	
	//处理NameException
	@ExceptionHandler(value=NameException.class)
	public ModelAndView doNameException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.addObject("tips", "@ControllerAdvice使用注解处理NameException");
		mv.addObject("ex", ex);
		mv.setViewName("nameError");
		return mv;
		
	}
	
	//处理AgeException
	@ExceptionHandler(value=AgeException.class)
	public ModelAndView doAgeException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.addObject("tips", "@ControllerAdvice使用注解处理AgeException");
		mv.addObject("ex", ex);
		mv.setViewName("ageError");
		return mv;
		
	}
	
	//处理其他异常
	@ExceptionHandler
	public ModelAndView doOtherException(Exception ex){
		ModelAndView mv = new ModelAndView();
		mv.addObject("tips", "@ControllerAdvice使用注解处理其他Exception");
		mv.addObject("ex", ex);
		mv.setViewName("defaultError");
		return mv;
		
	}
		
}
