package com.bjpowernode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.beans.Student;

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
	 * 处理器方法返回String:表示视图。
	 */
	@RequestMapping(value="some.do") 
	public String doSome(Student student,HttpServletRequest request){
		System.out.println("doSome:"+ student.getName() + " |  "+ student.getAge());
		
		//手工方式，将数据放入到request
		request.setAttribute("myname", student.getName());
		request.setAttribute("myage", student.getAge());
		request.setAttribute("mystudent", student);
		
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		//视图逻辑名称，需要使用视图解析器， 对视图执行的forward。
		//return "show";
		
		//使用视图的完整路径， 不能使用视图解析器
		return "/WEB-INF/jsp/show.jsp";
	}
	
}
