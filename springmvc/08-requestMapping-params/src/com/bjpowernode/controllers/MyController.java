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
	 * @RequestMapping:请求映射， 作用是把请求uri和方法绑定起来。 
	 *                 指定的请求有方法处理。
	 *            属性：1） value ，表示请求的uri。  uri是唯一值。
	 *                 value的值可以“/”开头，也可以不加"/"
	 *                 例如 /some.do , some.do
	 *                 
	 *                 2） method, 表示请求方式的。 它的值RequestMethod枚举值。
	 *                 3） params, 表示请求的参数信息。 是String[]
	 *            
	 *            位置：
	 *             1.在方法的上面， 常用的。
	 *             2.在类的上面
	 */
	//some.do请求中必须有name ,age 两个参数， 可以有其他参数
	@RequestMapping(value="some.do",params={"name","age"}) 
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
	//other.do请求中必须有age , 一定不能有name , 可以有其他参数
	@RequestMapping(value="other.do", params={"age","!name"}) 
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
	
	// first.do 请求中必须有name , 它的值必须zs ; 请求中有age ，值必须是23；可以有其他参数
	@RequestMapping(value = "first.do",params = {"name=zs","age=23"})
	public ModelAndView doFirst(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		// doSome()方法可以处理some.do的请求
		// 调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		
		String strname = request.getParameter("name");
		System.out.println("strName:"+strname);
		
		String strSex = request.getParameter("sex");
		System.out.println("sex:"+strSex);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "SpringMVC Annotation");
		mv.addObject("fun", "doFirst");

		// 指定视图
		mv.setViewName("show");

		// 数据和视图
		return mv;
	}
}
