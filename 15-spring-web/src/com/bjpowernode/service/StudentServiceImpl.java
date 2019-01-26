package com.bjpowernode.service;

import java.util.List;

import com.bjpowernode.beans.Student;
import com.bjpowernode.dao.StudentDao;

public class StudentServiceImpl implements StudentService {

	//依赖对象：引用类型
	private StudentDao studentDao; // mybatis的动态代理生成的对象
	
	//Ioc的设值注入
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
	
	@Override
	public int addStudent(Student student) {
		int rows = studentDao.insertStudent(student);
		return rows;
	}

	
	@Override
	public List<Student> queryStudents() {
		List<Student> students  = studentDao.selectStudents();
		return students;
	}

}
