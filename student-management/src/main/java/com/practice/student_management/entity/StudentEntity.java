package com.practice.student_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name =  "students")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "student_name",nullable = false)
	private String studentName;
	@Column(name = "dob",nullable = false)
	private String dateOfBirth;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;
	@Column(name = "gender", nullable = false)
	private Gender gender;
	@Column(name = "address",nullable = false)
	private String address;

	@OneToMany(mappedBy = "student_id", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ScoreEntity> scoreEntities;
//-----------------------------
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "student_course",
			joinColumns = {@JoinColumn(name = "student_id")},
			inverseJoinColumns = {@JoinColumn(name = "course_id")}
	)
	private List<CourseEntity> courseEntities;
//-------------------------------


	public List<CourseEntity> getCourseEntities() {
		return courseEntities;
	}

	public void setCourseEntities(List<CourseEntity> courseEntities) {
		this.courseEntities = courseEntities;
	}

	public Long getId() {
		return id;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public enum Gender{
		MALE,FEMALE,OTHER
	}

	public List<ScoreEntity> getScoreEntities() {
		return scoreEntities;
	}

	public void setScoreEntities(List<ScoreEntity> scoreEntities) {
		this.scoreEntities = scoreEntities;
	}
}
