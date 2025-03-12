package com.practice.student_management.dto;

import com.practice.student_management.entity.CourseEntity;
import com.practice.student_management.entity.StudentEntity;

public class ScoreDTO {
	private double score;
	private String id;
	private StudentEntity studentDTO;

	private CourseEntity courseEntity;

	public String getId() {
		return id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StudentEntity getStudentEntity() {
		return studentDTO;
	}

	public void setStudentEntity(StudentEntity studentDTO) {
		this.studentDTO = studentDTO;
	}

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
}
