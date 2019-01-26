package com.bjpowernode.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.beans.Student;
import com.bjpowernode.services.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	/**
	 * 引用类型 @Autowired, @Resource ; byType , byName
	 */
	//byType
	@Autowired
	private StudentService studentService;
	
	//定义处理器方法，处理请求
	@RequestMapping(value="addStudent",method = RequestMethod.POST)
	public ModelAndView addStudent(Student student){
		ModelAndView mv = new ModelAndView();
		int rows  = studentService.addStudent(student);
		//判断rows，得到处理结果
		if( rows > 0 ){
			mv.addObject("msg", "注册学生是成功的");
			mv.setViewName("success");
		} else {
			mv.addObject("msg", "注册失败！！！");
			mv.setViewName("fail");
		}
		return mv;
	}
	
	
	//查询学生，响应ajax请求
	@RequestMapping("listStudent")
	@ResponseBody
	public List<Student> queryStudent(){
		List<Student> students = studentService.queryStudents(); // null  ""
		//判断students对象
		if( students  == null){
			students = new ArrayList<Student>(); // "[]"
		}
		return students;  //"[{},{}]"
	}
	
}
