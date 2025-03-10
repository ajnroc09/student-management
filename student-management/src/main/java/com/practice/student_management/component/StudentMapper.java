package com.practice.student_management.component;

import com.practice.student_management.dto.StudentDTO;
import com.practice.student_management.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
	public void updateEntity(StudentDTO dto,StudentEntity entity){
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
	public StudentEntity toEntity(StudentDTO dto) {
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
	public StudentDTO toDTO(StudentEntity entity) {
		if(entity==null){
			return null;
		}
		StudentDTO dto =  new StudentDTO();
		dto.setAddress(entity.getAddress());
		dto.setEmail(entity.getEmail());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setStudentName(entity.getStudentName());
		dto.setGender(entity.getGender());
		return dto;

	}
}
