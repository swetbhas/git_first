package com.example.jpa.hibernate.demojpa.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demojpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository courseSpringDataRepository;

	@Test
	void findById() {
		logger.info("test is running....");
		Optional<Course> id = courseSpringDataRepository.findById(10001L);
		logger.info("test ->{}", id.isPresent());
	}

}
