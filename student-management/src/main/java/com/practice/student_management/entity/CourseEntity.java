package com.practice.student_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "course_name", nullable = false)
	private String courseName;
	@Column(name = "number_of_credit", nullable = false)
	private int numberOfCredit;

	@OneToMany(mappedBy = "course_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ScoreEntity> scoreEntities;
	//--------------------
	@ManyToMany(mappedBy = "courseEntities", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<StudentEntity> studentEntities;
//---------------------


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

	public String getId() {
		return id;
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
}
