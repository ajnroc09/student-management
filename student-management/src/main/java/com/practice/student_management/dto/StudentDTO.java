package com.practice.student_management.dto;

import com.practice.student_management.entity.ScoreEntity;
import com.practice.student_management.entity.StudentEntity;

import java.util.List;

public class StudentDTO {
private String id;
	private String studentName;
	private String dateOfBirth;
	private String email;
	private String phoneNumber;
	private StudentEntity.Gender gender;
	private String address;
	private List<ScoreDTO> scoreDTOS;
	private List<CourseDTO> courseDTOS;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StudentEntity.Gender getGender() {
		return gender;
	}

	public void setGender(StudentEntity.Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ScoreDTO> getScoreDTOS() {
		return scoreDTOS;
	}

	public void setScoreDTOS(List<ScoreDTO> scoreDTOS) {
		this.scoreDTOS = scoreDTOS;
	}

	public List<CourseDTO> getCourseDTOS() {
		return courseDTOS;
	}

	public void setCourseDTOS(List<CourseDTO> courseDTOS) {
		this.courseDTOS = courseDTOS;
	}
}
