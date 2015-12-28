package com.hsn.os.facultyjsf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hsn.os.facultyjsf.domain.Course;

@Repository("courseDao")
@Scope("prototype")
public class CourseDaoImpl implements CourseDao {

	private SessionFactory sessionFactory;

	@Autowired
	public CourseDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> findAll() {
		return getCurrentSession().createCriteria(Course.class).list();
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Course findByCode(String code) {
		return (Course) getCurrentSession().createQuery("from Course c where c.code = :code")
        	.setParameter("code", code).uniqueResult();
	}

	public Course findById(Long id) {
		return (Course) getCurrentSession().get(Course.class, id);
	}

	public void createNew(Course course) {
		getCurrentSession().save(course);
	}

	public void remove(Course course) {
		getCurrentSession().delete(course);
	}

	public void update(Course course) {
		getCurrentSession().update(course);
	}

}
