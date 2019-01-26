package com.bjpowernode.ba03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="myXueXiao")
public class School {
	
	@Value("清华大学")
	private String name;
	@Value("北京的海淀区")
	private String address;
	
	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + "]";
	}
	
	

}
