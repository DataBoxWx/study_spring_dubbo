package com.bjpowernode.ba04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="myXueXiao")
public class School {
	
	@Value("人民大学")
	private String name;
	@Value("北京的海淀区")
	private String address;
	
	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + "]";
	}
	
	

}
