package com.qa.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.studentmanagement.DTO.StudentDTO;
import com.qa.studentmanagement.entity.Student;
import com.qa.studentmanagement.exception.StudentNotFoundException;
import com.qa.studentmanagement.repo.StudentRepo;

@Service
public class StudentService {
	private StudentRepo repo;
	
	private ModelMapper mapper;
	
	public StudentService(StudentRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	  private StudentDTO mapToDTO(Student student) {
	        return this.mapper.map(student, StudentDTO.class);
	    }

	    public Student addStudent(Student student) {
	    	 Student saved =  this.repo.save(student);
	        return (saved);
	    }

	    public List<StudentDTO> getAllStudent() {
	        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	    }
	    public StudentDTO readOne(Long id) {
	      
	    	Student found = this.repo.findById(id).orElseThrow(StudentNotFoundException::new);
	        return this.mapToDTO(found);
	    }
	    public StudentDTO updateStudent(Long id, Student newStudent) {
	        java.util.Optional<Student> existingOptional = this.repo.findById(id);
	        Student existing = existingOptional.get();
	        existing.setName(newStudent.getName());
	        existing.setEmail_address(newStudent.getEmail_address());
	        existing.setAddress(newStudent.getAddress());
	        existing.setContact_no(newStudent.getContact_no());
	        Student updated =  this.repo.save(existing);
	        return this.mapToDTO(updated);
	    }

	    public boolean removeStudent(Long id) {
	        this.repo.deleteById(id);
	        boolean exists = this.repo.existsById(id);
	        return !exists;
	    }
	public Student create(Student student) {
		return this.repo.save(student);
	}

	

	public List<Student> readAll() {
		return this.repo.findAll();
	}

	public Student update(Student student, Long id) {
		Student toUpdate = this.findById(id);
		toUpdate.setName(student.getName());
		toUpdate.setEmail_address(student.getEmail_address());
		toUpdate.setAddress(student.getAddress());
		toUpdate.setContact_no(student.getContact_no());
		return this.repo.save(toUpdate);
	}

	private Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
