package com.qa.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.studentmanagement.entity.Course;




	@Repository
	public interface CourseRepo extends JpaRepository<Course, Long> {
		 @Query("SELECT p from Course p WHERE p.id = ?1")
		 Course findCourseByIDJPQL(Long id);

	}


