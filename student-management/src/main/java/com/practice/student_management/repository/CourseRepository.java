package com.practice.student_management.repository;

import com.practice.student_management.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
	@Query(value = "select * from students s where s.student_id = :studentId", nativeQuery = true)
	List<CourseRepository> findAllByStudentId(@Param("studentId") String studentId);
}
