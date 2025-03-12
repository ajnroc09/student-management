package com.practice.student_management.controller;

import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;
import com.practice.student_management.service.impl.ScoreServiceImplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	private final ScoreServiceImplement scoreService;
	public ScoreController(ScoreServiceImplement scoreService){
		this.scoreService=scoreService;
	}
	@PostMapping("/save")
	public ResponseEntity<ScoreDTO> saveScore(@RequestBody ScoreDTO scoreDTO) throws CourseNotFoundException, StudentNotFoundException {
		return new ResponseEntity<>(scoreService.saveScore(scoreDTO), HttpStatus.OK);
	}
}
