package com.fiap.codigo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Courseclass", schema = "public")
public class CourseClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	public Course course;
	
	@Column(name = "details", nullable = false, length = 1000)
	public String details;
	
	@Column(name = "estimatehours", nullable = false, precision = 4)
	public Double estimateHours;
	
	@Column(nullable = false)
	public Boolean isComplete;
	
	@Column(name = "videourl", nullable = false, length = 500)
	public String videoUrl;
	
//	public String pdf; //TODO - should we use BLOB?
	
	@Column(name = "codeexample", nullable = false, length = 5000)
	public String codeExample;
	
	@Column(name = "publishdate", nullable = false)
	public Date publishDate;
	
	@Column(name = "lang", nullable = false, length = 30)
	public String lang;
	
	@Column(name = "task", nullable = false, length = 100)
	public String task;
	
	
	

}
