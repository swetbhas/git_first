package com.example.jpa.hibernate.demojpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.hibernate.demojpa.entity.Passport;
import com.example.jpa.hibernate.demojpa.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void retrieveStudentPassport() {
		logger.info("test is running....");
		Student student=em.find(Student.class, 20001L);
		logger.info("student->{}",student);
		logger.info("passport->{}",student.getPassport());
	}
	
	
	@Test
	@Transactional
	void retrievePassportPassport() {
		logger.info("test is passport....");
		Passport passport=em.find(Passport.class, 40001L);
		logger.info("passport->{}",passport);
		logger.info("student->{}",passport.getStudent());
	}
	@Test
	void test()
	{
		studentRepository.someDummyOperation();
	}
	
//	@Test
//	@DirtiesContext
//	void deleteid() {
//		logger.info("test is running....");
//		studentRepository.deleteById(10002L);
//		assertNull(studentRepository.findById(10002L));
//	}
//
//	@Test
//	@DirtiesContext
//	void saveId() {
//		logger.info("save....");
//		Student student =studentRepository.findById(10001L);
//
//		student.setName("test save");
//		studentRepository.save(student);
//		assertEquals("test save",studentRepository.findById(10001L).getName());
//
//	}
//	
//	
//	@Test
//	@DirtiesContext
//	void playWithEntityManager() {
//		logger.info("playWithEntityManager....");
//
//	}
//	


}
