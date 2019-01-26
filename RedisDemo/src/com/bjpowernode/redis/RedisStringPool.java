package com.bjpowernode.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisStringPool {

	public static void main(String[] args) {
		//创建Jedis对象， 指定连接Redis的ip和端口
		/**
		 * host:运行redis的linux服务器的ip
		 * port:redis的端口
		 */
		String host = "192.168.160.128";
		int port = 6379;
		
		//使用JedisPool ，获取Jedis对象
		JedisPool pool  = null;
		Jedis jedis = null;
		try{
			pool = RedisUtils.open(host, port);
			//获取Jedis对象
			jedis  = pool.getResource();
			//调用Jedis对象的方法
			jedis.set("break","豆浆和油条111");
			
			//获取key的值
			System.out.println("break:" + jedis.get("break"));
			
			//创建多个key-value
			jedis.mset("lunch","水饺111","dinner","红烧肉111");
			
			//获取多个key的值
			List<String> values  = jedis.mget("break","lunch","dinner");
			for(String val: values){
				System.out.println(val);
			}
		}finally{
			//关闭Jedis对象，使用完毕后要放回到线程池， 让其他线程使用。
			if( jedis != null){
				jedis.close();
			}
		}
	
		
		
		
	}
}
