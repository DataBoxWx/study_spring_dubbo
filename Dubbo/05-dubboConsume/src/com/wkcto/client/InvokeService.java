package com.wkcto.client;

import java.util.List;

import com.wkcto.beans.Movie;
import com.wkcto.beans.Weather;
import com.wkcto.service.MovieService;
import com.wkcto.service.WeatherService;

public class InvokeService {

	//定义远程对象作为属性
	private WeatherService remoteWs;
	
	private MovieService remoteMs;

	// IoC：设值注入
	public void setRemoteWs(WeatherService remoteWs) {
		this.remoteWs = remoteWs;
	}
	
	
	
	public void setRemoteMs(MovieService remoteMs) {
		this.remoteMs = remoteMs;
	}



	public void printService(){
		Weather wea  = remoteWs.queryWeather("101020100");
		System.out.println("远程对象作为属性："+wea);
		
		List<Movie> movies = remoteMs.getMovieList();
		System.out.println("远程电影："+movies);
	}
}
