package com.bjpowernode.controllers;

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
	 * @RequestMapping:请求映射， 作用是把请求uri和方法绑定起来。 
	 *                 指定的请求有方法处理。
	 *            属性：value ，表示请求的uri。  uri是唯一值。
	 *                 value的值可以“/”开头，也可以不加"/"
	 *                 例如 /some.do , some.do
	 *                 
	 *                 value的值可以理解为 <url-pattern>
	 *            位置：
	 *             1.在方法的上面， 常用的。
	 *             2.在类的上面
	 */
	@RequestMapping(value={"some.do","first.do"}) 
	public ModelAndView doSome(){
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		mv.addObject("msg", "SpringMVC Annotation");
		mv.addObject("fun","doSome");
		
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
	
	@RequestMapping(value={"other.do","second.do"}) 
	public ModelAndView doOther(){
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		mv.addObject("msg", "SpringMVC Annotation");
		mv.addObject("fun","doOther");
		
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
}
