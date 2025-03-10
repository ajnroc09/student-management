package com.practice.student_management.exception;

public class StudentNotFoundException extends Exception {
	private String msg;

	public StudentNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
