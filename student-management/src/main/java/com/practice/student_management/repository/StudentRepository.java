package com.practice.student_management.repository;
import com.practice.student_management.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {
	@Query(value = "select * from courses c where c.course_id = :courseId", nativeQuery = true)
	List<StudentEntity> findAllByCourseId(@Param("courseId") String courseId);
}
