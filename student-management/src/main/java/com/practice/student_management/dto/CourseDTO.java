package com.practice.student_management.dto;

import com.practice.student_management.entity.ScoreEntity;
import com.practice.student_management.entity.StudentEntity;

import java.util.List;

public class CourseDTO {
	private String id;

	private String courseName;

	private int numberOfCredit;

	private List<ScoreDTO> scoreDTOS;
	private List<StudentDTO> studentDTOS;

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

	public List<ScoreDTO> getScoreDTOS() {
		return scoreDTOS;
	}

	public void setScoreDTOS(List<ScoreDTO> scoreDTOS) {
		this.scoreDTOS = scoreDTOS;
	}

	public List<StudentDTO> getStudentDTOS() {
		return studentDTOS;
	}

	public void setStudentDTOS(List<StudentDTO> studentDTOS) {
		this.studentDTOS = studentDTOS;
	}
}
