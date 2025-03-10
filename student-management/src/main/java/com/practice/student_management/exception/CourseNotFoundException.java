package com.practice.student_management.exception;

public class CourseNotFoundException extends Exception {
	private String msg;

	public CourseNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
