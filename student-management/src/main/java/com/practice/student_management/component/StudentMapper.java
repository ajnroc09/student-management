package com.practice.student_management.component;

import com.practice.student_management.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
	public void updateEntity(com.practice.student_management.dto.StudentDTO dto, StudentEntity entity){
		if(dto==null||entity == null) {
			return;
		}
		entity.setAddress(dto.getAddress());
		entity.setEmail(dto.getEmail());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setStudentName(dto.getStudentName());
		entity.setGender(dto.getGender());

	}
	public StudentEntity toEntity(com.practice.student_management.dto.StudentDTO dto) {
		if(dto==null){
			return null;
		}
		StudentEntity entity = new StudentEntity();
		entity.setAddress(dto.getAddress());
		entity.setEmail(dto.getEmail());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setStudentName(dto.getStudentName());
		entity.setGender(dto.getGender());
		return entity;
	}
	public com.practice.student_management.dto.StudentDTO toDTO(StudentEntity entity) {
		if(entity==null){
			return null;
		}
		com.practice.student_management.dto.StudentDTO dto =  new com.practice.student_management.dto.StudentDTO();
		dto.setAddress(entity.getAddress());
		dto.setEmail(entity.getEmail());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setStudentName(entity.getStudentName());
		dto.setGender(entity.getGender());
		return dto;

	}
}
