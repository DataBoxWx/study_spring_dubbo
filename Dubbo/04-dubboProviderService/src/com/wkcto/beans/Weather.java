package com.wkcto.beans;

import java.io.Serializable;

public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;
	// 城市名称
	private String name;
	// 温度
	private int temp;
	// 湿度
	private String sd;
	// 天气的概况
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "天气新 [城市名称=" + name + ", 温度=" + temp + ", 湿度=" + sd + ", 天气概况=" + desc + "]";
	}
	
	
}
