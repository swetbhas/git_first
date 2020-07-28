package com.example.jpa.hibernate.demojpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.demojpa.entity.Passport;
import com.example.jpa.hibernate.demojpa.entity.Student;
@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public Student findById(Long id)
	{
		return em.find(Student.class,id);
	}
	
	public void deleteById(Long id) {
		Student student=findById(id);
		 em.remove(student);
	}

	public void save(Student student)
	{
		if(student.getId()==null)
		{em.persist(student);}
		else
		{
			em.merge(student);
		}
	}

public void saveStudentWithPassport()

{
	Passport passport=new Passport("Z12345");
	em.persist(passport);
	logger.info("saveStudentWithPassport start");
	Student student1=new Student("Swetta");
	student1.setPassport(passport);
	em.persist(student1);
//	Student student2=new Student("Web service in 100-updated");
//	em.persist(student2);
//	logger.info("before flush");
//	em.flush();
//	student1.setName("CS in 100-updated-1");
//	em.detach(student2);
//	student1.setName("ANG in 100-detach-1");
//	
//	logger.info("playWithEntityManager end");
	}
public void someDummyOperation() {
	Student student=em.find(Student.class, 20001L);
	
	Passport passport=student.getPassport();
	
	passport.setName("E12345");
	
	student.setName("Sam-updated");
}

}




//select * from student