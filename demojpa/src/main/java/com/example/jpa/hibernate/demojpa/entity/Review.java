package com.example.jpa.hibernate.demojpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	private String description;
	
    @ManyToOne
    private Course course;
	protected Review() {}

	public Review(String description, String rating) {
		super();
		this.description = description;
		this.rating=rating;
	}

	public Long getId() {
		return id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + "]";
	}

	
	
	

}
