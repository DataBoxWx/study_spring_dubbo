package com.bjpowernode.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

	private static JedisPool pool;
	//创建线程池， 池中是多个Jedis对象
	public static JedisPool open(String host, int port){
		if( pool == null ){
			//创建JedisPool对象
			
			//先创建config对象
			JedisPoolConfig config =new JedisPoolConfig();
			//设置线程池中Jedis最大的个数
			config.setMaxTotal(20);
			//设置空闲数
			config.setMaxIdle(2);
			//设置检查项，保证从池中获取的Jedis是可用的。
			config.setTestOnBorrow(true);
			
			//创建JedisPool
			/**
			 * poolConfig:配置器
			 * host：ip 
			 * port: 端口
			 * timeout：连接的超时， 毫秒值
			 * passoword:访问redis的密码
			 */
			pool = new JedisPool(config, host, port, 6000, "123456");
			
		}
		return pool;
	}

	//关闭线程池
	public static void close(){
		if( pool != null){
			pool.close();
			pool = null;
		}
	}
}

