package com.practice.student_management.controller;

import com.practice.student_management.dto.CourseDTO;
import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.service.impl.CourseServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseServiceImplement courseService;
	public CourseController (CourseServiceImplement courseService) {
		this.courseService=courseService;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CourseDTO> updateCourse(@PathVariable("id") String id, @RequestBody CourseDTO courseDTO ) throws CourseNotFoundException{
		return new ResponseEntity<>(courseService.updateCourse(id,courseDTO), HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO){
		return new ResponseEntity<>(courseService.saveCourse(courseDTO),HttpStatus.OK);
	}
	@GetMapping("/get-all")
	public  ResponseEntity<List<CourseDTO>> getAllCourses(){
		return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
	}

}
