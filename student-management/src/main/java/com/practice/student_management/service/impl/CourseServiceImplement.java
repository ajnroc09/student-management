package com.practice.student_management.service.impl;

import com.practice.student_management.component.CourseMapper;
import com.practice.student_management.component.ScoreMapper;
import com.practice.student_management.component.StudentMapper;
import com.practice.student_management.dto.CourseDTO;
import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.entity.CourseEntity;
import com.practice.student_management.entity.StudentEntity;
import com.practice.student_management.exception.CourseNotFoundException;
import com.practice.student_management.exception.StudentNotFoundException;
import com.practice.student_management.repository.CourseRepository;
import com.practice.student_management.repository.ScoreRepository;
import com.practice.student_management.repository.StudentRepository;
import com.practice.student_management.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CourseServiceImplement implements CourseService {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final ScoreRepository scoreRepository;
	private final StudentMapper studentMapper;
	private final CourseMapper courseMapper;
	private final ScoreMapper scoreMapper;


	public CourseServiceImplement(StudentRepository studentRepository,
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
	public CourseDTO saveCourse(CourseDTO courseDTO) {
		CourseEntity courseEntity = courseMapper.toEntity(courseDTO);
		courseRepository.save(courseEntity);
		return courseMapper.toDTO(courseEntity);
	}

	@Override
	public CourseDTO updateCourse(String id, CourseDTO courseDTO) throws CourseNotFoundException {
		CourseEntity courseEntity = courseRepository.findById(id)
				.orElseThrow(()->new CourseNotFoundException("Course not found"));
	courseMapper.updateEntity(courseDTO,courseEntity);
	courseRepository.save(courseEntity);
	return courseMapper.toDTO(courseEntity);
	}

	@Override
	public void deleteCourse(String id) throws CourseNotFoundException {
		CourseEntity courseEntity = courseRepository.findById(id)
				.orElseThrow(()->new CourseNotFoundException("Course not found"));
		courseRepository.delete(courseEntity);
	}
	@Override
	public CourseDTO getCourseById(String id) throws CourseNotFoundException {
		CourseEntity courseEntity= courseRepository.findById(id)
				.orElseThrow(()->new CourseNotFoundException("Course not found"));
		CourseDTO courseDTO = courseMapper.toDTO(courseEntity);

		List<StudentDTO> studentDTOS =courseEntity.getStudentEntities().stream()
				.map(studentMapper::toDTO)
				.collect(Collectors.toList());

		List<ScoreDTO> scoreDTOS =courseEntity.getScoreEntities().stream()
				.map(scoreMapper::toDTO)
				.collect(Collectors.toList());

		courseDTO.setStudentDTOS(studentDTOS);
		courseDTO.setScoreDTOS(scoreDTOS);
		return courseDTO;
	}
	@Override
	public List<CourseDTO> getAllCourses() {
		List<CourseEntity> courseEntities = courseRepository.findAll();
		return courseEntities.stream()
				.map(courseMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> getAllCourseByStudentId(String id) throws StudentNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));
		return studentEntity.getCourseEntities().stream()
				.map(courseMapper::toDTO)
				.collect(Collectors.toList());
	}
}
