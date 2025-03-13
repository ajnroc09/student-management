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
import com.practice.student_management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentService {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final ScoreRepository scoreRepository;
	private final StudentMapper studentMapper;
	private final CourseMapper courseMapper;
	private final ScoreMapper scoreMapper;


	public StudentServiceImplement(StudentRepository studentRepository,
	                               CourseRepository courseRepository,
	                               ScoreRepository scoreRepository,
	                               StudentMapper studentMapper,
	                               CourseMapper courseMapper,
	                               ScoreMapper scoreMapper) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.scoreRepository = scoreRepository;
		this.studentMapper = studentMapper;
		this.courseMapper = courseMapper;
		this.scoreMapper = scoreMapper;

	}


	@Override
	public StudentDTO saveStudent(StudentDTO studentDTO) throws CourseNotFoundException {
		StudentEntity studentEntity = studentMapper.toEntity(studentDTO);

		List<CourseEntity> courseEntities = studentDTO.getCourseDTOS().stream()
				.map(
						courseDTO -> {
							try {
								return courseRepository.findById(courseDTO.getId())
										.orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseDTO.getId()));
							} catch (CourseNotFoundException e) {
								throw new RuntimeException(e);
							}
						}
				)
				.toList();

		studentEntity.setCourseEntities(courseEntities);

		studentRepository.save(studentEntity);
		return studentMapper.toDTO(studentEntity);
	}

	@Override
	public StudentDTO updateStudent(String id, StudentDTO studentDTO) throws CourseNotFoundException, StudentNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));
		studentMapper.updateEntity(studentDTO, studentEntity);
		List<CourseEntity> courseEntities = studentDTO.getCourseDTOS().stream()
				.map(
						courseDTO -> {
							try {
								return courseRepository.findById(courseDTO.getId())
										.orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseDTO.getId()));
							} catch (CourseNotFoundException e) {
								throw new RuntimeException(e);
							}
						}
				)
				.toList();

		studentEntity.setCourseEntities(courseEntities);
		studentRepository.save(studentEntity);
		return studentMapper.toDTO(studentEntity);

	}

	@Override
	public void deleteStudent(String id) throws StudentNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));
		studentRepository.delete(studentEntity);
	}

	//--------------------------
	@Override
	public StudentDTO getStudentById(String id) throws StudentNotFoundException {
		StudentEntity studentEntity = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found"));
		com.practice.student_management.dto.StudentDTO studentDTO = studentMapper.toDTO(studentEntity);

		List<CourseDTO> courseDTOS = studentEntity.getCourseEntities().stream()
				.map(courseMapper::toDTO)
				.collect(Collectors.toList());

		List<ScoreDTO> scoreDTOS = studentEntity.getScoreEntities().stream()
				.map(scoreMapper::toDTO)
				.collect(Collectors.toList());

		studentDTO.setCourseDTOS(courseDTOS);
		studentDTO.setScoreDTOS(scoreDTOS);

		return studentDTO;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		return studentEntities.stream()
				.map(studentMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<StudentDTO> getAllStudentsByCourseId(String courseId) throws CourseNotFoundException {
		CourseEntity courseEntity = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course not found"));
		return studentRepository.findAllByCourseId(courseEntity.getId())
				.stream()
				.map(studentMapper::toDTO)
				.collect(Collectors.toList());
	}
}
