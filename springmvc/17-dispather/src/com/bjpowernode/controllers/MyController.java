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
	 * 当处理器方法返回ModelAndView，转发到视图。
	 * 语法 setViewName("forward:视图的完整路径")
	 * 
	 * forward有一个特点：不和视图解析器一同工作的。 就当程序中视图解析器不存在。
	 */
	@RequestMapping(value="some.do") 
	public ModelAndView doSome(String name, Integer age){
		
		System.out.println("doSome:"+ name + " |  "+ age);
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		//指定视图 forward:视图的完整路径
		mv.setViewName("forward:/WEB-INF/jsp/show.jsp");

		return mv;
	}
	
	/**
	 * 返回值是String,表示视图
	 * 语法：forward:视图的完整路径
	 */
	@RequestMapping(value="other.do") 
	public String doViewName(String name, Integer age){
		System.out.println("doSome:"+ name + " |  "+ age);
		//指定视图 forward:视图的完整路径
		return "forward:/WEB-INF/jsp/show.jsp";
	}
	
	/**
	 * 返回值ModelAndView
	 * 接收到请求，然后转发给其他的处理，继续处理请求
	 */
	@RequestMapping("dispather.do")
	public ModelAndView doDispather(String name,Integer age){
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		//转发到其他的处理器， 语法 forward:xxx.do
		//mv.setViewName("forward:process.do");
		
		mv.setViewName("forward:/test/process.do");
		
		return mv;
	}
	
	//继续处理请求
	@RequestMapping("process.do")
	public String doProcess(){
		System.out.println("=========doProcess============");
		//逻辑视图名称 ， forward到/WEB-INF/jsp/show.jsp
		return "show";
	}
	
	
}
