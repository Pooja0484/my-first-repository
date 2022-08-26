package com.qa.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.studentmanagement.DTO.StudentDTO;
import com.qa.studentmanagement.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	 @Query("SELECT p from Student p WHERE p.id = ?1")
	    Student findStudentByIDJPQL(Long id);

	
}
