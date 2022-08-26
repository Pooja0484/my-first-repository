package com.qa.studentmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
	
	private Long id;

    
    private String name;
    
   
    private String email_address;
  
    
    private String Address;
    
    
    private Long contact_no;
}
