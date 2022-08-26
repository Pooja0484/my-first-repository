package com.qa.studentmanagement.DTO;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDTO {
	private Long id;

    
    private String name;
    
    
    private String duration;
  
    
    
    private float fees;
}
