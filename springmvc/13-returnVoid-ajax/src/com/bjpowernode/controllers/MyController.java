package com.bjpowernode.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 处理器方法返回void,响应ajax
	 * @throws IOException 
	 */
	@RequestMapping(value="myajax.do") 
	public void doSome(String name, Integer age,HttpServletResponse response) throws IOException{
		System.out.println("doSome:"+ name + " |  "+ age);
		
		//调用Service处理请求。将结果通过HttpServletResponse输出给浏览器
		
		//将处理结果，组成对象
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		
		//Student - Json , 使用Jackson的工具库的 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(student);
		
		//将json输出给浏览器
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
		

	}
	
}
