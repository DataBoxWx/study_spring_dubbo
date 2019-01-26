package com.bjpowernode.ba04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyCollections {
	//具有集合性质的属性
	private String [] mystr;
	private Set<String> myset;
	private List<Student> mylist;
	private Map<String,Integer> mymap;
	private Properties myprop;
	
	//复杂的集合类型
	private List<Map<String,String>> mylistmap;
	
	public void setMystr(String[] mystr) {
		this.mystr = mystr;
	}
	public void setMyset(Set<String> myset) {
		this.myset = myset;
	}
	public void setMylist(List<Student> mylist) {
		this.mylist = mylist;
	}
	public void setMymap(Map<String, Integer> mymap) {
		this.mymap = mymap;
	}
	public void setMyprop(Properties myprop) {
		this.myprop = myprop;
	}
	
	
	public void setMylistmap(List<Map<String, String>> mylistmap) {
		this.mylistmap = mylistmap;
	}
	@Override
	public String toString() {
		return "MyCollections [mystr=" + Arrays.toString(mystr) + ", myset=" + myset + ", mylist=" + mylist + ", mymap="
				+ mymap + ", myprop=" + myprop + ", mylistmap=" + mylistmap + "]";
	}
	
	
 
	
}
