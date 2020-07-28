package com.example.jpa.hibernate.demojpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
     public Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	protected Passport() {}

	public Passport(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", name=" + name + "]";
	}
	
	

}
