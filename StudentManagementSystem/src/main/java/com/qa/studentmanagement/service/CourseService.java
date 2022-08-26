package com.qa.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.studentmanagement.DTO.CourseDTO;

import com.qa.studentmanagement.entity.Course;

import com.qa.studentmanagement.exception.CourseNotFoundException;

import com.qa.studentmanagement.repo.CourseRepo;

@Service
public class CourseService {
	private CourseRepo repo;
	 
	private ModelMapper mapper;
	
	public CourseService( CourseRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	 private CourseDTO mapToDTO(Course student) {
	        return this.mapper.map(student, CourseDTO.class);
	    }

	    public Course addCourse(Course course) {
	    	Course saved =  this.repo.save(course);
	        return (saved);
	    }

	    public List<CourseDTO> getAllCourse() {
	        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	    }
	    public CourseDTO readOne(Long id) {
		      Course found = this.repo.findById(id).orElseThrow(CourseNotFoundException::new);
		        return this.mapToDTO(found);
		    }
	    public CourseDTO updateCourse(Long id, Course newCourse) {
	        java.util.Optional<Course> existingOptional = this.repo.findById(id);
	        Course existing = existingOptional.get();
	        existing.setName(newCourse.getName());
	        existing.setDuration(newCourse.getDuration());
	        existing.setFees(newCourse.getFees());
	        
	       Course updated =  this.repo.save(existing);
	        return this.mapToDTO(updated);
	    }

	    public boolean removeCourse(Long id) {
	        this.repo.deleteById(id);
	        boolean exists = this.repo.existsById(id);
	        return !exists;
	    }
	public  Course create( Course course) {
		return this.repo.save(course);
	}

	
	public List< Course> readAll() {
		return this.repo.findAll();
	}

	public  Course update( Course course, Long id) {
		 Course toUpdate = this.findById(id);
		toUpdate.setName( course.getName());
		toUpdate.setDuration(course.getDuration());
		toUpdate.setFees(course.getFees());
		
		return this.repo.save(toUpdate);
	}

	private Course findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
