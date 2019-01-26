package com.bjpowernode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取myobject.txt使用反射创建对象，给属性赋值
 *
 */
public class Container {
	//使用集合保存创建好的对象
	private Map<String,Object> map = new HashMap<>();
	
	//定义方法，从Map中获取已经创建好的对象
	public Object getBean(String name){
		Object object = null;
		if( map.containsKey(name)){
			object = map.get(name);
		}
		return object;
	}

	public Container(File file) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException{
		init(file);
	}
	
	/*
	 * 读取myobject.txt使用反射创建对象，给属性赋值
	 */
	private void init(File file) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		FileReader fin = new FileReader(file);
		BufferedReader bin = new BufferedReader(fin);
		//读取的每行数据
		String line = null;
		
		while( (line = bin.readLine()) != null ){
			/**
			 *  service=com.bjpowernode.service.UserServiceImpl
				myUserDao=com.bjpowernode.dao.UserDaoMySQLImpl
				myUserDaoOracle=com.bjpowernode.dao.UserDaoOracleImpl
				service#userDao=myUserDaoOracle  //给属性赋值
			 */
			String data [] = line.split("=");
			String left = data[0];// service#userDao
			String right = data[1];// myUserDaoOracle
			
			if( left.indexOf("#") > 0 ){
				//处理是最后一行
				String ref [] = left.split("#");
				String ref_left = ref[0];//service：对象名（Map）
				String ref_right = ref[1];//userDao:属性名
				
				Object obj = map.get(ref_left);
				//获取对象的Class, 使用反射给属性赋值
				Class clazz  = obj.getClass();
				//要赋值的属性： Field
				Field field  = clazz.getDeclaredField(ref_right);
				//设置安全性，给属性赋值
				field.setAccessible(true);
				//给属性赋值
				field.set(obj, map.get(right));
				
				
			} else {
				//前三行 ，要创建对象，使用反射
				Object object = makeObject(right);
				
				if( object != null){
					map.put(left, object);
				}
				
			}
			
		}
		
	}
	
	//使用反射创建对象
	private Object makeObject(String className){
		Object object = null;
		try{
			object = Class.forName(className).newInstance();
		} catch(Exception e){
			e.printStackTrace();
		}
		return object;
		
	}
}
