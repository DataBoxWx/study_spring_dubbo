package com.bjpowernode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * 当处理器方法返回ModelAndView，重定向到视图。
	 * 语法 setViewName("redirect:视图的完整路径")
	 * 
	 * redirect有一个特点：不和视图解析器一同工作的。 就当程序中视图解析器不存在。
	 * 
	 * 重定向
	 * 1.不能访问，受保护的/WEB-INF
	 * 2.放入到Model中简单类型的数据，能够转为字符串，作为get请求参数传递。 对象类型是不能转为字符串。
	 * 3.在目标页面中，使用 ${param.参数名}
	 * 
	 */
	@RequestMapping(value="some.do") 
	public ModelAndView doSome(String name, Integer age){
		
		System.out.println("doSome:"+ name + " |  "+ age);
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		//Model中简单类型的数据，能够转为String，作为重定向的get请求参数
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		
		//添加对象到Model
		Student student = new Student();
		student.setAge(age);
		student.setName("zhangsan");
		mv.addObject("mystudent", student);
		
		//指定视图 redirect:视图的完整路径
		//mv.setViewName("redirect:/WEB-INF/jsp/show.jsp"); 不能访问/WEB-INF
		mv.setViewName("redirect:/show.jsp");
		//http://localhost:8080/18-redirect/show.jsp?myname=zs&myage=23
		return mv;
	}
	
	/**
	 * 返回值是String,表示视图
	 * 语法：redirect:视图的完整路径
	 */
	@RequestMapping(value="other.do") 
	public String doViewName(String name, Integer age){
		System.out.println("doSome:"+ name + " |  "+ age);
		//指定视图 redirect:视图的完整路径
		return "redirect:/show.jsp";
	}
	
	/**
	 * 返回值ModelAndView
	 * 接收到请求，然后重定向给其他的处理器，处理请求
	 */
	@RequestMapping("doredirect.do")
	public ModelAndView doDispather(String name,Integer age){
		ModelAndView mv = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		
		//重定向到其他的处理器
		mv.setViewName("redirect:process.do");
		//http://localhost:8080/myweb/process.do?myname=xxx&myage=20
		return mv;
	}
	
	//继续处理请求
	@RequestMapping("process.do")
	public String doProcess(String myname, Integer myage){
		System.out.println("=========doProcess============" + myname + " |  "+ myage);
		//逻辑视图名称 ， forward到/WEB-INF/jsp/other.jsp
		return "other";
	}
	
	
}
