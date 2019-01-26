package com.bjpowernode.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//实现HandlerInterceptor接口的类叫做拦截器
public class MyInterceptor implements HandlerInterceptor {

	private long btime;
	/**
	 * 预处理方法：在请求处理之前先执行的方法。 用户的请求首先到达该方法。
	 *           在这个方法中可以对请求做判断，处理。
	 * 参数：
	 * Object handler:处理器对象。
	 * 
	 * 返回值boolean
	 * true: 请求能够处理， 拦截器的afterCompletion能执行。
	 * false: 请求终止执行， 拦截器的afterCompletion不能执行。
	 *        
	 * preHandle可以看做是应用程序的开关， preHandle=true,开关打开的，请求能处理。
	 * 如果preHandle=false，开关关闭。 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		btime = System.currentTimeMillis();
		System.out.println("MyInterceptor拦截器的preHandle()");
		return true;
	}

	/**
	 * 后处理方法：在处理器方法之后执行的， 最大的特点是能够获取到处理器方法的执行结果（ModelAndView）
	 *           作用是可以修改目标方法的执行结果， 对处理结果做二次修改。
	 * 参数：
	 * Object handler:处理器对象。
	 * ModelAndView mv:处理器方法的执行结果
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		System.out.println("MyInterceptor拦截器的postHandle()" + mv);
		
		//修改原来的执行结果 ModelAndView
		
		if( mv != null){
			//修改数据， 添加一个的mydate ,表示当前时间
			mv.addObject("mydate", new Date());
			
			//修改视图
			mv.setViewName("other");
		}
		
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
		
		long etime = System.currentTimeMillis();
		System.out.println("请求的处理时长："+(etime - btime));
	}

	

}
