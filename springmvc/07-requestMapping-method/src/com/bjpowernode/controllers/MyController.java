package com.bjpowernode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 *            属性：1） value ，表示请求的uri。  uri是唯一值。
	 *                 value的值可以“/”开头，也可以不加"/"
	 *                 例如 /some.do , some.do
	 *                 
	 *                 2） method, 表示请求方式的。 它的值RequestMethod枚举值。
	 *            
	 *            位置：
	 *             1.在方法的上面， 常用的。
	 *             2.在类的上面
	 */
	//some.do只能使用get请求方式
	@RequestMapping(value="some.do",method =RequestMethod.GET) 
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
	//other.do只能接收post请求方式
	@RequestMapping(value="other.do",method  =  RequestMethod.POST ) 
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
	
	// first.do 不指定method属性， 请求方式没有限制
	@RequestMapping(value = "first.do")
	public ModelAndView doFirst() {
		// doSome()方法可以处理some.do的请求
		// 调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "SpringMVC Annotation");
		mv.addObject("fun", "doFirst");

		// 指定视图
		mv.setViewName("show");

		// 数据和视图
		return mv;
	}
}
