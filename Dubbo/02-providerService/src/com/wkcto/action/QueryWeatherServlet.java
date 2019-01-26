package com.wkcto.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wkcto.beans.Weather;
import com.wkcto.service.WeatherService;
import com.wkcto.service.WeatherServiceImpl;

// @WebServlet 创建Servlet对象，  value属性值是： url-pattern
@WebServlet("/qwservlet")
public class QueryWeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public QueryWeatherServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求的cityCode
		String cityCode = request.getParameter("cityCode");
		
		//调用Service，获取CityCode的Weather对象
		WeatherService service = new WeatherServiceImpl();
		Weather wea  = service.queryWeather(cityCode);
		
		//将查询结果wea，输出。 响应请求。
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(wea.toString());
		pw.flush();
		pw.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
