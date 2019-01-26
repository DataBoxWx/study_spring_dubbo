package com.bjpowernode.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//实现HandlerInterceptor接口的类叫做拦截器
public class MyInterceptor implements HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor拦截器的preHandle()");
		
		String userName = "";
		//从Session中获取用户的信息
		Object attr = request.getSession().getAttribute("user");
		if( attr != null){
			userName = (String)attr;
		}
		
		//判断登录的用户
		if( !"zs".equals(userName)){
			//非法用户，不能访问系统的
			request.getRequestDispatcher("/result.jsp").forward(request, response);
			return false;
		}
		
		//合法用户
		return true;
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		System.out.println("MyInterceptor拦截器的postHandle()" + mv);
	}

	/**
	 * 最后执行的方法： 可以做资源回收， 内存释放等收尾工作。
	 *              在视图对象处理完成之后，执行的方法。
	 * 参数：
	 * Object handler:处理器对象。
	 * Exception ex:异常
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor拦截器的afterCompletion()");
		
	}

	

}
