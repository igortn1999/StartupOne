package com.fiap.codigo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentClassRegistration {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	Student student;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	CourseClass courseClass;
	
	@Column(name = "studentcode", nullable = true, length = 3000)
	String studentCode;
	
	@Column(name = "startdate", nullable = false)
	Date startdate;
	
	@Column(name = "enddate", nullable = true)
	Date enddate;
	
	@Column(name = "iscomplete", nullable = false)
	public Boolean isComplete;
	
	//TODO - percent complete should be a sum of all classes that are completed inside Course class (?)
	
}

