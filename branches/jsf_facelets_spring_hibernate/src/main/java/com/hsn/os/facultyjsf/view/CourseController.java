package com.hsn.os.facultyjsf.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hsn.os.facultyjsf.domain.Course;
import com.hsn.os.facultyjsf.service.CourseService;
import com.hsn.os.facultyjsf.view.mode.ModeManager;
import com.hsn.os.facultyjsf.view.mode.PageMode;

@Component("courseController")
@Scope("request")
public class CourseController implements Serializable {

	private final Logger logger = LoggerFactory.getLogger(CourseController.class);;
	
	private CourseService courseService;
	private Course course;
	
	public CourseController() {}
	
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostConstruct
	public void onLoad() {
		String courseId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("courseId");
		if (courseId != null)
			course = courseService.findById(Long.valueOf(courseId));
	}
	
	public String save() {
		courseService.createNew(course);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Course is saved successfully.", "Success");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		setCourse(null);
		
		return "listCourses";
	}
	
	public String update() {
		courseService.update(course);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Course is updated successfully.", "Success");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		setCourse(null);
		
		return "listCourses";
	}
	
	public String remove() {
		courseService.remove(course);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Course is removed successfully.", "Success");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		setCourse(null);
		
		return "listCourses";
	}
	
	public Course getCourse() {
		if (course == null) {
			course = new Course();
		}
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	// will be called from the listCourses action to set the id of course to be viewed
	public void setCourseIdToView(String courseId) {
		setCourse(courseService.findById(Long.valueOf(courseId)));
	}
	
	private Object getFromSession(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	private void putInSession(String key, Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, object);
	}

}
