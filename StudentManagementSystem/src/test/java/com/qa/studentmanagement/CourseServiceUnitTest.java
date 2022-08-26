package com.qa.studentmanagement;



import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.studentmanagement.entity.Course;

import com.qa.studentmanagement.repo.CourseRepo;

import com.qa.studentmanagement.service.CourseService;

@SpringBootTest
public class CourseServiceUnitTest {
	 @Autowired
	    private CourseService service;

	    @MockBean
	    private CourseRepo repo;
	    @Test
	    void testCreate(){
	        // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
	        final Course TEST_Course = new Course(null,"Medical Science", "3 years", 14000F, null);
	        final Course TEST_SAVED_Course = new Course(7L,"Medical Science", "3 years", 14000F, null);

	        // WHEN
	        Mockito.when(this.repo.save(TEST_Course)).thenReturn(TEST_SAVED_Course);

	        // THEN
	        Assertions.assertThat(this.service.addCourse(TEST_Course)).isEqualTo(TEST_SAVED_Course);

	        // verify that our repo was accessed exactly once
	        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_Course);
	   
	    }
}
