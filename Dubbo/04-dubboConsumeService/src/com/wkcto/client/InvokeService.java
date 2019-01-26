package com.wkcto.client;

import com.wkcto.beans.Weather;
import com.wkcto.service.WeatherService;

public class InvokeService {

	//定义远程对象作为属性
	private WeatherService remoteWs;

	// IoC：设值注入
	public void setRemoteWs(WeatherService remoteWs) {
		this.remoteWs = remoteWs;
	}
	
	public void printService(){
		Weather wea  = remoteWs.queryWeather("101020100");
		System.out.println("远程对象作为属性："+wea);
	}
}
