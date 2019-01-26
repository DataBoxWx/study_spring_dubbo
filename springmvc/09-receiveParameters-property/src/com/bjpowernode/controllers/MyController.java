package com.bjpowernode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller：创建处理器对象，默认是单例对象
 *    位置：类的上面
 *    
 * @RequestMapping:
 *       value: 指定请求uri的公共部分， 叫做模块名称。
 *              对请求地址统一管理。
 */
@Controller
@RequestMapping("user")
public class MyController {
	//定义方法，处理请求。 在处理器类中定义的方法叫做处理器方法。
	


	/**
	 * 逐个接收请求参数： 要求请求中参数名和处理器方法形参名一样。
	 * 
	 * 框架的处理：
	 *  String strName = request.getParameter("name");
	 *  String strAge = request.getParameter("age");
	 *  
	 * 处理器的适配器执行处理器方法。
	 *  doSome(strName,Integer.parseInt(strAge))
	 *  
	 * 框架可以对String到 int ,long ,float , double做转换。
	 */
	@RequestMapping(value="some.do") 
	public ModelAndView doSome(String name, Integer age){
		
		System.out.println("doSome:"+ name + " |  "+ age);
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
	
}
