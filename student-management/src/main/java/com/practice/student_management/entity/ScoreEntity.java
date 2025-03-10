package com.practice.student_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scores")
public class ScoreEntity {
	@Column(name = "score",nullable = false)
	private double score;
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private StudentEntity studentEntity;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private CourseEntity courseEntity;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if (score >= 0 && score <= 10) {
			this.score = score;
		} else {
			throw new IllegalArgumentException("score must be in range of 0 to 10");
		}
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
