package com.wkcto.service;

import com.wkcto.beans.Weather;

public interface WeatherService {

	public Weather queryWeather(String cityCode);
}
