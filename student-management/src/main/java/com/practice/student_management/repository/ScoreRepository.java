package com.practice.student_management.repository;

import com.practice.student_management.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, String> {
	@Query(value = "select * from students s where s.student_id = :studentId", nativeQuery = true)
	List<ScoreEntity> findAllByStudentId(@Param("studentId") String studentId);

	@Query(value = "select * from courses c where c.course_id = :courseId", nativeQuery = true)
	List<ScoreEntity> findAllByCourseId(@Param("courseId") String courseId);
}
