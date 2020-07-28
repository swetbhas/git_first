package com.example.jpa.hibernate.demojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.hibernate.demojpa.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course,Long>{

}
