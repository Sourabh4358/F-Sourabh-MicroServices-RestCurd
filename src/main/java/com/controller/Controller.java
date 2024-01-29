package com.controller;



import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class Controller {
	
	private StudentService studentService;
	
	public Controller(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
	  try {
		  Student sid = studentService.addStudent(student);
		  return ResponseEntity.ok(sid);
	} catch (Exception e) {
		// TODO: handle exception
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		try {
			Student sid =  studentService.getStudent(id);
			return ResponseEntity.ok(sid);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}
	@GetMapping("/all/info")
	public ResponseEntity<List<Student>> getAllStudents() {
	    try {
	        List<Student> students = studentService.getAllStudent();
	        return ResponseEntity.ok(students);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
	    }
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		try {
			studentService.deleteStudent(id);
			return ResponseEntity.ok("Student with id " + id + " delete");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					 .body("Error deleting student with ID " + id + ": " + e.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<String> update( @RequestBody Student studentDetails) {
	
		ResponseEntity<String> resp=null;
		boolean present=studentService.isPresent(studentDetails.getStudentId());
		if(present) { 
		studentService.updateStudent(studentDetails);
		resp=new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
		} else {
		
			resp=new ResponseEntity<String>("Record '"+studentDetails.getStudentId()+" ' not found",HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
	
		
}
