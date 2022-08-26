package com.qa.studentmanagement.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.studentmanagement.DTO.CourseDTO;
import com.qa.studentmanagement.DTO.StudentDTO;
import com.qa.studentmanagement.entity.Course;
import com.qa.studentmanagement.entity.Student;
import com.qa.studentmanagement.service.CourseService;

@RestController
@RequestMapping("/course")

public class CourseController {
	private CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Course create(@RequestBody Course course) {
		return this.service.addCourse(course);
	}

	@GetMapping("/read/{id}")
	public CourseDTO readOne(@PathVariable Long id) {
		return this.service.readOne(id);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<CourseDTO>> readAll() {
		return ResponseEntity.ok(this.service.getAllCourse());
	}
	@PutMapping("/update/{id}")
	public CourseDTO update(@PathVariable Long id, @RequestBody Course course) {
		return  this.service.updateCourse(id, course);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


