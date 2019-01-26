package com.bjpowernode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.exceptions.AgeException;
import com.bjpowernode.exceptions.MyUserException;
import com.bjpowernode.exceptions.NameException;

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
	



	@RequestMapping(value="some.do") 
	public ModelAndView doSome(String name, Integer age) throws MyUserException{
		System.out.println("doSome:"+ name + " |  "+ age);
		
//		try{
		//抛出异常给框架， 由框架处理异常 ，不要自己写try { }  catch() {} 
		if(!"zs".equals(name)){
			throw new NameException("姓名不正确!!!");
		}
		
		if( age == null || age.intValue() > 50){
			throw new AgeException("年龄比较大了");
		}
		
//		}catch(Exception e){
//			
//		}
		
		ModelAndView mv  = new ModelAndView();
		mv.addObject("myname", name);
		mv.addObject("myage", age);
		//指定视图
		mv.setViewName("show");
		
		//数据和视图
		return mv;
	}
	
}
