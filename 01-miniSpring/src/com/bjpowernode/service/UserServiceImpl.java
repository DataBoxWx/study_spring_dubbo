package com.bjpowernode.service;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.UserDaoMySQLImpl;
import com.bjpowernode.dao.UserDaoOracleImpl;

/**
 * 依赖关系： classA使用了classB的属性或方法， classA依赖classB.
 *
 */
public class UserServiceImpl implements UserService {

	//引用类型
	//private UserDao userDao = new UserDaoMySQLImpl();
	private UserDao userDao;//  = new UserDaoOracleImpl();
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser() {
		//调用Dao的方法，操作数据库的操作
		userDao.insertUser();
	}

}
