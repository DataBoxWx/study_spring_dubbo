package com.bjpowernode.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 实现HandlerExceptionResolver接口的类叫做异常处理器。
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 当程序中抛出异常时，中央调度器会调用 resolveException ， 处理异常。
	 * 参数：
	 * Object handler：处理器对象
	 * Exception ex:抛出的异常对象
	 * 
	 * 返回值：ModelAndView 
	 * 表示异常的提示数据和视图页面
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object handler,Exception ex) {
		//处理异常。 调用数据库代码，把异常记录到数据库， 记录到日志文件，发送邮件，短信。
		//判断异常的类型，分别做处理
		ModelAndView  mv = new ModelAndView();
		mv.addObject("ex", ex);
		if( ex instanceof NameException){
			mv.addObject("tips", "有关姓名的异常");
			mv.setViewName("nameError");
		} else if( ex instanceof AgeException){
			mv.addObject("tips", "年龄方面的异常");
			mv.setViewName("ageError");
		} else {
			//其他异常
			mv.addObject("tips", "其他异常情况");
			mv.setViewName("defaultError");
		}
		
		return mv;
	}

	

}
