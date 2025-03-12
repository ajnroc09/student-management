package com.practice.student_management.exception;

public class ScoreNotFoundException extends Exception {
	private String msg;

	public ScoreNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
