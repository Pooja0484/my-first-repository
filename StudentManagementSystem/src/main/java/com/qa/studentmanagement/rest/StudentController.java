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

import com.qa.studentmanagement.DTO.StudentDTO;
import com.qa.studentmanagement.entity.Student;
import com.qa.studentmanagement.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public Student create(@RequestBody Student student) {
		return this.service.addStudent(student);
	}

	@GetMapping("/read/{id}")
	public StudentDTO readOne(@PathVariable Long id) {
		return this.service.readOne(id);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<StudentDTO>> readAll() {
		return ResponseEntity.ok(this.service.getAllStudent());
	}

	@PutMapping("/update/{id}")
	public StudentDTO update(@PathVariable Long id, @RequestBody Student student) {
		return  this.service.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
