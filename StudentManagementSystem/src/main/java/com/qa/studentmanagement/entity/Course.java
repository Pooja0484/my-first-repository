package com.qa.studentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Entity
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public class Course {
		
		@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    @Column
		    private String name;
		    
		    @Column
		    private String duration;
		  
		    
		    @Column
		    private float fees;
		   
		    @ManyToOne
		    private Student student;  
	}

