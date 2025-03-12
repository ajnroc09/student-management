package com.practice.student_management.service;

import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.dto.StudentAverageScoreDTO;
import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.ScoreNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;

import java.util.List;

public interface ScoreService {
	ScoreDTO updateScore(ScoreDTO scoreDTO)
			throws CourseNotFoundException,StudentNotFoundException, ScoreNotFoundException;
	ScoreDTO saveScore(ScoreDTO scoreDTO)
			throws CourseNotFoundException,StudentNotFoundException;

	// Tính điểm trung bình của mỗi sinh viên
	List<StudentAverageScoreDTO> calculateAverageScore();

	// Lọc sinh viên có điểm trung bình > 5
	List<StudentAverageScoreDTO> filterStudentsByAverageScore(
			double minAverageScore);

}

