package com.bjpowernode.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjpowernode.beans.Student;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	/**
	 * 引用类型 :自动注入 @Autowired , @Resource ; byName , byType
	 */
	//byType
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public int addStudent(Student student) {
		int rows  = studentDao.insertStudent(student);
		return  rows;
	}

	@Override
	public List<Student> queryStudents() {
		List<Student> students = studentDao.selectStudents();
		return students;
	}

}
