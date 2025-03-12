package com.practice.student_management.dto;

public class StudentAverageScoreDTO {
	private StudentDTO student;
	private double averageScore;


	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
}