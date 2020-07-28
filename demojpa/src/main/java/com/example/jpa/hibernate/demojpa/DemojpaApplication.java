package com.example.jpa.hibernate.demojpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.hibernate.demojpa.entity.Course;
import com.example.jpa.hibernate.demojpa.repository.CourseRepository;
import com.example.jpa.hibernate.demojpa.repository.StudentRepository;


@SpringBootApplication
public class DemojpaApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	
		studentRepository.saveStudentWithPassport();
//		repository.playWithEntityManager();
//		logger.info("Course 10001 -> {}",course);
	}

}
