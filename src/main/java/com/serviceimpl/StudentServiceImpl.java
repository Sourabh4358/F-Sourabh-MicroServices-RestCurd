package com.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Student;
import com.repository.StudentRepository;
import com.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

    List<Student> list = new ArrayList<Student>();
    
	@Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepository.findById(id).orElseThrow(() ->
		new RuntimeException("Student Not Found"));
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void updateStudent(Student studentDetails) {
		studentRepository.save(studentDetails);
		
	}

	@Override
	public boolean isPresent(Long id) {
	return studentRepository.existsById(id);
	}
	
	
//	@Override
//	public void save(Long id, Student studentDetails) {
//		list.stream().map(s->{
//			if(s.getStudentId()==id) {
//				s.setStudentFirstName(studentDetails.getStudentFirstName());
//				s.setStudentMiddleName(studentDetails.getStudentMiddleName());
//				s.setStudentLastName(studentDetails.getStudentLastName());
//			}
//			return s;
//		}).collect(Collectors.toList());
//		
//		
//	}

	

}
