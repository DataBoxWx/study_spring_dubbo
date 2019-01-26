package com.bjpowernode.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.beans.Student;
import com.bjpowernode.service.StudentService;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的参数
		String strName = request.getParameter("name");
		String strAge  = request.getParameter("age");
		
		//创建Spring容器对象
		String configLocation="applicationContext.xml";
		//ServletContext  -- 全局的
		ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		System.out.println("容器对象ctx:" + ctx);
		
		//从容器中获取Service
		StudentService service  = (StudentService) ctx.getBean("studentService");
		
		
		
		Student student = new Student();
		student.setName(strName);
		student.setAge(Integer.parseInt(strAge));
		
		service.addStudent(student);
		
		//显示结果也页面用户
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
