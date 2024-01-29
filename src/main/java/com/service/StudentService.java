package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	
	Student getStudent(Long id);
	
	List<Student> getAllStudent();

	void deleteStudent(Long id);

	void updateStudent(Student studentDetails);

	boolean isPresent(Long i);
	
}
