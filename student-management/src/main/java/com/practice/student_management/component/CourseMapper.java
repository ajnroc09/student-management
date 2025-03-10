package com.practice.student_management.component;

import com.practice.student_management.dto.CourseDTO;
import com.practice.student_management.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
	public void updateEntity(CourseDTO dto, CourseEntity entity) {
		if(dto==null||entity==null) {
			return;
		}
		entity.setCourseName(dto.getCourseName());
		entity.setNumberOfCredit(dto.getNumberOfCredit());
	}
	public CourseEntity toEntity(CourseDTO dto){
		if(dto==null) {
			return null;
		}
		CourseEntity entity = new CourseEntity();
		entity.setCourseName(dto.getCourseName());
		entity.setNumberOfCredit(dto.getNumberOfCredit());
		return entity;
	}
	public CourseDTO toDTO(CourseEntity entity) {
		if(entity==null){
			return null;
		}
		CourseDTO dto = new CourseDTO();
		dto.setId(entity.getId());
		dto.setCourseName(entity.getCourseName());
		dto.setNumberOfCredit(entity.getNumberOfCredit());
		return dto;
	}

}
