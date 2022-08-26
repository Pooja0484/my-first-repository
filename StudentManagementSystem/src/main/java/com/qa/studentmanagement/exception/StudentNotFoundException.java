package com.qa.studentmanagement.exception;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student does not exist with that ID")
public class StudentNotFoundException extends EntityNotFoundException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 230418181701598L;
}
