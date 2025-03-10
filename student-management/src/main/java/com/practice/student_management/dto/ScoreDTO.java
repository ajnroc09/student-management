package com.practice.student_management.dto;

import com.practice.student_management.entity.CourseEntity;
import com.practice.student_management.entity.StudentEntity;

public class ScoreDTO {
	private double score;
	private StudentEntity studentEntity;

	private CourseEntity courseEntity;


	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}
}
