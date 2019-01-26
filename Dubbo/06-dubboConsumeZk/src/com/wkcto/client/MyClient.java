package com.wkcto.client;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wkcto.beans.Weather;
import com.wkcto.service.WeatherService;

public class MyClient {

	public static void main(String[] args) throws IOException {
		//创建spring的容器对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo-consume.xml");
		//从spring中获取 dubbo的代理对象
//		WeatherService remoteProxy  = (WeatherService) ctx.getBean("remoteWeatherService");
		//通过代理对象，执行远程服务的调用，就像调自己的方法一样。
		/*Weather wea  = remoteProxy.queryWeather("101010100");
		System.out.println("remoteProxy:"+remoteProxy.getClass().getName());
		System.out.println("远程对象的调用结果："+wea);*/
		
		InvokeService invoke = (InvokeService) ctx.getBean("invokeService");
		invoke.printService();
		
		//System.in.read();
	}

}
