package com.practice.student_management.dto;

import com.practice.student_management.entity.ScoreEntity;
import com.practice.student_management.entity.StudentEntity;
import jakarta.persistence.*;

import java.util.List;

public class CourseDTO {
	private String id;

	private String courseName;

	private int numberOfCredit;

	private List<ScoreEntity> scoreEntities;
	private List<StudentEntity> studentEntities;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getNumberOfCredit() {
		return numberOfCredit;
	}

	public void setNumberOfCredit(int numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}

	public List<ScoreEntity> getScoreEntities() {
		return scoreEntities;
	}

	public void setScoreEntities(List<ScoreEntity> scoreEntities) {
		this.scoreEntities = scoreEntities;
	}

	public List<StudentEntity> getStudentEntities() {
		return studentEntities;
	}

	public void setStudentEntities(List<StudentEntity> studentEntities) {
		this.studentEntities = studentEntities;
	}
}
