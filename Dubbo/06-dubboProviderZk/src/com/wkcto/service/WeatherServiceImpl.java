package com.wkcto.service;

import com.wkcto.beans.Weather;

public class WeatherServiceImpl implements WeatherService {

	@Override
	public Weather queryWeather(String cityCode) {
		System.out.println("*************WeatherServiceImpl*******************");
		Weather wea  = new Weather();
		//判断城市代码
		if( "101010100".equals(cityCode)){
			wea.setName("北京");
			wea.setTemp(35);
			wea.setSd("58%");
			wea.setDesc("天气闷热，潮湿");
		} else if("101020100".equals(cityCode)){
			wea.setName("上海");
			wea.setTemp(38);
			wea.setSd("70%");
			wea.setDesc("天气闷热，非常潮湿");
		} else {
			wea.setName("全国平均");
			wea.setTemp(38);
			wea.setSd("70%");
			wea.setDesc("天气闷热，非常潮湿");
		}
		return wea;
	}

}
