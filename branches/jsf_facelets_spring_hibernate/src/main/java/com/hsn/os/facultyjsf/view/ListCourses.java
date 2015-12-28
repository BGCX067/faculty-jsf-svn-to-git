package com.hsn.os.facultyjsf.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hsn.os.facultyjsf.domain.Course;
import com.hsn.os.facultyjsf.service.CourseService;
import com.hsn.os.facultyjsf.view.mode.ModeManager;
import com.hsn.os.facultyjsf.view.mode.PageMode;

@Component("listCourses")
@Scope("request")
public class ListCourses implements Serializable {

	private List<Course> courses;
	private CourseService courseService;
	
	public ListCourses() {}
	
	@Autowired
	public ListCourses(CourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getCourses() {
		if (courses == null) {
			courses = courseService.findAll();
		}
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
