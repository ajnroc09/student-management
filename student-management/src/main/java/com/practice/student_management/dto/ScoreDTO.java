package com.practice.student_management.dto;

import com.practice.student_management.entity.CourseEntity;
import com.practice.student_management.entity.StudentEntity;

public class ScoreDTO {
	private double score;
	private String id;
	private StudentDTO studentDTO;

	private CourseDTO courseDTO;

	public String getId() {
		return id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public CourseDTO getCourseDTO() {
		return courseDTO;
	}

	public void setCourseEntity(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}
}
