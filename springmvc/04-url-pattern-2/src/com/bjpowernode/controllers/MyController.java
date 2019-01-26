package com.bjpowernode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 实现Controller接口的类是处理器（处理器）
 * MyController能处理用户的请求， 也叫做后端控制器（back controller）
 *
 */
public class MyController implements Controller {

	/**
	 * 处理器类定义的方法：叫做处理器方法。
	 * 处理器方法能够处理用户的请求。
	 * 
	 * 返回值：
	 *  ModelAndView : 模型和视图。
	 *  Model:模型，也就是数据（M）
	 *  View:视图，用来显示数据的。（V）
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//  handleRequest  == Servlet中的doGet, doPost
		// 调用Service对象，处理请求， 将处理结果返回给用户。
		ModelAndView mv = new ModelAndView();
		
		//向Model添加Service的处理结果
		//框架对模型数据的处理是：放入到request作用域。  request.setAttribute("msg", "Hello SpringMVC");
		mv.addObject("msg", "Hello SpringMVC");
		mv.addObject("function", "handleRequest");
		
		
		//指定视图，显示数据
		//viewName:视图的完整路径
		//mv.setViewName("/show.jsp");
		//mv.setViewName("/WEB-INF/jsp/show.jsp");
		//mv.setViewName("/WEB-INF/jsp/other.jsp");
		
		//指定视图的逻辑名称（文件名称） ，配合视图解析器指定视图
		// 视图解析器的前缀 + 逻辑名称 + 后缀  == 视图的完整路径
		mv.setViewName("show");
		
		//对视图的处理是，执行forward.
		//request.getRequestDispather("/show.jsp").forward(request,reponse);
		return mv;
	}

}
