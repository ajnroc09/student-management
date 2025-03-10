package com.practice.student_management.service;

import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;

import java.util.List;

public interface ScoreService {
	ScoreDTO updateScore(ScoreDTO ScoreDTO) throws CourseNotFoundException,StudentNotFoundException;
	ScoreDTO saveEmployee(ScoreDTO employeeDTO) throws CourseNotFoundException,StudentNotFoundException;

	//Tính điểm trung bình của mỗi sinh viên
	//Lọc sinh viên có điểm trung bình

}

