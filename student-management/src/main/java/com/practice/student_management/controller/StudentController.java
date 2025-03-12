package com.practice.student_management.controller;

import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;
import com.practice.student_management.service.impl.StudentServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
	private final StudentServiceImplement studentService;
	public StudentController(StudentServiceImplement studentService){
		this.studentService= studentService;}
	@PostMapping("/save")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) throws CourseNotFoundException{
		return new ResponseEntity<>(studentService.saveStudent(studentDTO), HttpStatus.OK);
	}

	@GetMapping("/get-all")
	public  ResponseEntity<List<StudentDTO>> getAllStudent(){
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO) throws CourseNotFoundException, StudentNotFoundException {
		return new ResponseEntity<>(studentService.updateStudent(id,studentDTO),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deleteStudent(@PathVariable("id") String id) throws StudentNotFoundException {
		studentService.deleteStudent(id);
		return new ResponseEntity<>("Delete successfully!",HttpStatus.OK);
	}

}

