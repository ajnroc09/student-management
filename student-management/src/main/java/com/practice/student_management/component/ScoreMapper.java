package com.practice.student_management.component;

import com.practice.student_management.entity.ScoreEntity;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {
	public void updateEntity(com.practice.student_management.dto.ScoreDTO dto, ScoreEntity entity) {
		if(dto==null||entity==null) {
			return;
		}
		entity.setScore(dto.getScore());
	}
	public ScoreEntity toEntity(com.practice.student_management.dto.ScoreDTO dto) {
		if(dto==null){
			return null;
		}
		ScoreEntity entity = new ScoreEntity();
		entity.setScore(dto.getScore());
		return entity;
	}

	public com.practice.student_management.dto.ScoreDTO toDTO(ScoreEntity entity) {
		if(entity==null) {
			return null;
		}
		com.practice.student_management.dto.ScoreDTO dto = new com.practice.student_management.dto.ScoreDTO();
		dto.setScore(entity.getScore());
		return dto;

	}
}
