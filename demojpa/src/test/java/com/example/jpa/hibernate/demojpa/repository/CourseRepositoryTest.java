package com.example.jpa.hibernate.demojpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demojpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
		logger.info("test is running....");
		assertEquals("JPA found",courseRepository.findById(10001L).getName());
	}
	
	@Test
	@DirtiesContext
	void deleteid() {
		logger.info("test is running....");
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
	}

	@Test
	@DirtiesContext
	void saveId() {
		logger.info("save....");
		Course course =courseRepository.findById(10001L);

		course.setName("test save");
		courseRepository.save(course);
		assertEquals("test save",courseRepository.findById(10001L).getName());

	}
	
	
	@Test
	@DirtiesContext
	void playWithEntityManager() {
		logger.info("playWithEntityManager....");
	courseRepository.playWithEntityManager();

	}
	


}
