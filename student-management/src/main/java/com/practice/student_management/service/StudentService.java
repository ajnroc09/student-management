package com.practice.student_management.service;

import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
	StudentDTO saveStudent(ScoreDTO employeeDTO) throws CourseNotFoundException;
	StudentDTO updateStudent(StudentDTO courseDTO) throws CourseNotFoundException;
	void deleteStudent(String id) throws StudentNotFoundException;
	StudentDTO getStudentById(String id) throws StudentNotFoundException;
	List<StudentDTO> getAllStudents();
	List<StudentDTO> getAllStudentsByCourseId(String id) throws CourseNotFoundException;
}
