package com.example.jpa.hibernate.demojpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.demojpa.entity.Course;
@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Course findById(Long id)
	{
		return em.find(Course.class,id);
	}
	
	public void deleteById(Long id) {
		Course course=findById(id);
		 em.remove(course);
	}

	public void save(Course course)
	{
		if(course.getId()==null)
		{em.persist(course);}
		else
		{
			em.merge(course);
		}
	}

public void playWithEntityManager()

{
	
	logger.info("playWithEntityManager start");
	Course course1=new Course("Web service in 100-updated");
	em.persist(course1);
	Course course2=new Course("Web service in 100-updated");
	em.persist(course2);
	logger.info("before flush");
	em.flush();
	course1.setName("CS in 100-updated-1");
	em.detach(course2);
	course1.setName("ANG in 100-detach-1");
	
	logger.info("playWithEntityManager end");
	}

}


//select * from course