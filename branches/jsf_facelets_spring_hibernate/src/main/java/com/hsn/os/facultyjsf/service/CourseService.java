package com.hsn.os.facultyjsf.service;

import java.util.List;

import com.hsn.os.facultyjsf.domain.Course;

public interface CourseService {

	void createNew(Course course);
	
	void update(Course course);
	
	void remove(Course course);
	
	List<Course> findAll();
	
	Course findById(Long id);
	
	Course findByCode(String code);
}
