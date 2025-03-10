package com.practice.student_management.service;

import com.practice.student_management.dto.CourseDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;

import java.util.List;

public interface CourseService {
	CourseDTO updateCourse(CourseDTO courseDTO) throws CourseNotFoundException;
	void deleteCourse(String id) throws CourseNotFoundException;
	CourseDTO getCourseById(String id) throws CourseNotFoundException;
	List<CourseDTO> getAllCourses();
	List<CourseDTO> getAllCourseByStudentId(String id) throws StudentNotFoundException;

}
