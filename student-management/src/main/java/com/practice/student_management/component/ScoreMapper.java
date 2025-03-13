package com.practice.student_management.component;

import com.practice.student_management.dto.ScoreDTO;
import com.practice.student_management.entity.ScoreEntity;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper {
	public void updateEntity(ScoreDTO dto, ScoreEntity entity) {
		if(dto==null||entity==null) {
			return;
		}
		entity.setScore(dto.getScore());
	}
	public ScoreEntity toEntity(ScoreDTO dto) {
		if(dto==null){
			return null;
		}
		ScoreEntity entity = new ScoreEntity();
		entity.setScore(dto.getScore());
		return entity;
	}

	public ScoreDTO toDTO(ScoreEntity entity) {
		if(entity==null) {
			return null;
		}
		ScoreDTO dto = new ScoreDTO();
		dto.setId(entity.getId());
		dto.setScore(entity.getScore());
		return dto;

	}
}
