package com.qa.studentmanagement.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course does not exist with that ID")
public class CourseNotFoundException extends EntityNotFoundException {
	


}
