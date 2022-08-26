package com.qa.studentmanagement.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
	
        @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column
	    private String name;
	    
	    @Column
	    private String email_address;
	  
	    @Column
	    private String Address;
	    
	    @Column
	    private Long contact_no;
	   
	    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private List<Course> course = new ArrayList<>();
    
}
