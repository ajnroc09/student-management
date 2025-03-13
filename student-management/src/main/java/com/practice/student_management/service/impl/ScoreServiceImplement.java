package com.practice.student_management.service.impl;

import com.practice.student_management.component.CourseMapper;
import com.practice.student_management.component.ScoreMapper;
import com.practice.student_management.component.StudentMapper;
import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.dto.StudentAverageScoreDTO;
import com.practice.student_management.entity.CourseEntity;
import com.practice.student_management.entity.ScoreEntity;
import com.practice.student_management.entity.StudentEntity;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.ScoreNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;
import com.practice.student_management.repository.CourseRepository;
import com.practice.student_management.repository.ScoreRepository;
import com.practice.student_management.repository.StudentRepository;
import com.practice.student_management.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScoreServiceImplement implements ScoreService {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final ScoreRepository scoreRepository;
	private final StudentMapper studentMapper;
	private final CourseMapper courseMapper;
	private final ScoreMapper scoreMapper;


	public ScoreServiceImplement(StudentRepository studentRepository,
	                               CourseRepository courseRepository,
	                               ScoreRepository scoreRepository,
	                               StudentMapper studentMapper,
	                               CourseMapper courseMapper,
	                               ScoreMapper scoreMapper) {
		this.studentRepository= studentRepository;
		this.courseRepository = courseRepository;
		this.scoreRepository = scoreRepository;
		this.studentMapper=studentMapper;
		this.courseMapper=courseMapper;
		this.scoreMapper=scoreMapper;
	}

	@Override
	public ScoreDTO updateScore(ScoreDTO scoreDTO) throws CourseNotFoundException, StudentNotFoundException, ScoreNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(scoreDTO.getStudentDTO().getId())
				.orElseThrow(()->new StudentNotFoundException("Student not found"));
		CourseEntity courseEntity = courseRepository.findById(scoreDTO.getCourseDTO().getId())
				.orElseThrow(()->new CourseNotFoundException("Course not found"));
		ScoreEntity scoreEntity=scoreRepository.findById(scoreDTO.getId())
				.orElseThrow(()->new ScoreNotFoundException("Score not found"));
		scoreEntity.setScore(scoreDTO.getScore());
		scoreEntity.setCourseEntity(courseEntity);
		scoreEntity.setStudentEntity(studentEntity);

		scoreRepository.save(scoreEntity);
		return scoreMapper.toDTO(scoreEntity);
	}


	@Override
	public ScoreDTO saveScore(ScoreDTO scoreDTO) throws CourseNotFoundException, StudentNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(scoreDTO.getStudentDTO().getId())
				.orElseThrow(()->new StudentNotFoundException("Student not found"));
		CourseEntity courseEntity = courseRepository.findById(scoreDTO.getCourseDTO().getId())
				.orElseThrow(()->new CourseNotFoundException("Course not found"));

		ScoreEntity scoreEntity = new ScoreEntity();
		scoreEntity.setStudentEntity(studentEntity);
		scoreEntity.setCourseEntity(courseEntity);
		scoreEntity.setScore(scoreDTO.getScore());

		scoreRepository.save(scoreEntity);
		return scoreMapper.toDTO(scoreEntity);

	}
//-----------------
	@Override
	public List<StudentAverageScoreDTO> calculateAverageScore() {
		List<ScoreEntity> allScores = scoreRepository.findAll();
	return null;
	}

	@Override
	public List<StudentAverageScoreDTO> filterStudentsByAverageScore(double minAverageScore) {
		return null;
	}
}
