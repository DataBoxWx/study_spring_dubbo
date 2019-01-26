package com.bjpowernoder.service;

public class NumberServiceImpl implements NumberService {

	@Override
	public Integer addNumber(Integer n1, Integer n2, Integer n3) {
		// 对addNumber方法的参数做检查，参数不是null并且每个参数值是大于 0 时做三个数的相加。
		// 如果参数检查不满足条件， addNumber的结果是 null
		Integer result = n1.intValue()  + n2.intValue() + n3.intValue();
		
		return result;
	}

}
