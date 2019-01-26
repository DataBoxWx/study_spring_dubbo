package com.bjpowernode.services;

import java.util.List;

import com.bjpowernode.beans.Student;

public interface StudentService {

	int addStudent(Student student);
	List<Student> queryStudents();
}
