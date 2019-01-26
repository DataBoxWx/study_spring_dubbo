package com.bjpowernode.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
		//ApplicationContext ctx  = new ClassPathXmlApplicationContext(configLocation);
		
		
		//从ServletContext中获取容器对象
		//String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
		//WebApplicationContext ctx  = (WebApplicationContext) this.getServletContext().getAttribute(key);
		
		
		//使用框架提供的方法， 获取容器对象
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
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
