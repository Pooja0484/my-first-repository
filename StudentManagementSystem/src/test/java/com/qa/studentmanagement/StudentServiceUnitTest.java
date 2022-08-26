package com.qa.studentmanagement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.studentmanagement.DTO.StudentDTO;
import com.qa.studentmanagement.entity.Student;
import com.qa.studentmanagement.repo.StudentRepo;
import com.qa.studentmanagement.service.StudentService;

@SpringBootTest
public class StudentServiceUnitTest {
	 @Autowired
	    private StudentService service;

	    @MockBean
	    private StudentRepo repo;
	    @Test
	    void testCreate(){
	        // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
	      
	    	final Student TEST_Student = new Student(null,"Jay warner", "jaywarner@college.com", "London L20 4EF", 7785675432L);
	        final Student TEST_SAVED_Student = new Student(11L, "Jay warner", "jaywarner@college.com", "London L20 4EF", 7785675432L);

	        // WHEN
	        Mockito.when(this.repo.save(TEST_Student)).thenReturn(TEST_SAVED_Student);

	        // THEN
	        Assertions.assertThat(this.service.addStudent(TEST_Student)).isEqualTo(TEST_SAVED_Student);

	        // verify that our repo was accessed exactly once
	        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_Student);
	    }
}
