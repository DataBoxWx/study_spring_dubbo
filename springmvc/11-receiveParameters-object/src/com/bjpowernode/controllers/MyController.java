package com.bjpowernode.controllers;

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
	 *  使用对象接受请求的参数：要求对象的属性名和请求中的参数名一样。
	 */
	@RequestMapping(value="some.do") 
	public ModelAndView doSome(Student student){
		
		System.out.println("doSome:"+ student.getName() + " |  "+ student.getAge());
		//doSome()方法可以处理some.do的请求
		//调用Service处理请求， 把Dao中的数据取出来。 显示给用户
		ModelAndView mv  = new ModelAndView();
		mv.addObject("myname", student.getName());
		mv.addObject("myage", student.getAge());
		mv.addObject("mystudent", student);
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
	
}
