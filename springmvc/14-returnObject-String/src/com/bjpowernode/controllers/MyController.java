package com.bjpowernode.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.beans.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	 * 处理器方法返回对象--String
	 * String表示数据，不是视图。
	 * 
	 * 怎么区分String是视图还是数据？
	 * 看处理器方法上面有无@ResponseBody.
	 * 如果有@ResponseBody， 字符串String就是数据。反之就是视图。
	 * 
	 * @ResponseBody:把处理后的数据，通过应答对象输出到浏览器。
	 * 
	 *  解决乱码： 使用@RequestMapping的属性produces，指定输出数据格式和编码
	 *  
	 * 框架对象返回值是对象的处理步骤：
	 * 1.框架根据返回值的数据类型（String），遍历寻找能够处理返回值的HttpMessageConverter接口的实现类对象。
	 *   String - StringHttpMessageConverter
	 * 2.使用HttpMessageConverter接口的实现类对象，处理返回值的数据。
	 *   是调用StringHttpMessageConverter ， 使用text/plain，对数据编码默认是 ISO-8859-1.
	 * 3.通过@ResponseBody,把2中的数据，通过HttpServletResponse对象，输出到应答体（浏览器）
	 */
	@RequestMapping(value="myajax.do",produces="text/plain;charset=utf-8") 
	@ResponseBody
	public String doSome() {
		System.out.println("doSome:");
		//返回String表示数据
		return "Hello SpringMVC HttpMessageConverter  使用中文";
	}
	
}
