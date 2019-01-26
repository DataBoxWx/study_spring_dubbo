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
public class MyController {

	@RequestMapping(value="some.do") 
	public ModelAndView doSome(String name, Integer age){
		System.out.println("处理器MyController的doSome:"+ name + " |  "+ age);
		ModelAndView mv  = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
	
}
