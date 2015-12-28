package com.hsn.os.facultyjsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hsn.os.facultyjsf.dao.CourseDao;
import com.hsn.os.facultyjsf.domain.Course;

@Service("courseService")
@Scope("prototype")
public class CourseServiceImpl implements CourseService {
	
	private CourseDao courseDao;
	
	@Autowired
	public CourseServiceImpl(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void createNew(Course course) {
		courseDao.createNew(course);
	}

	public List<Course> findAll() {
		return courseDao.findAll();
	}

	public Course findByCode(String code) {
		return courseDao.findByCode(code);
	}

	public Course findById(Long id) {
		return courseDao.findById(id);
	}

	public void remove(Course course) {
		courseDao.remove(course);
	}

	public void update(Course course) {
		courseDao.update(course);
	}

}
