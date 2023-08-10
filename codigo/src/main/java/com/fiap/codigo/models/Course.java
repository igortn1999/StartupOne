package com.fiap.codigo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fiap.codigo.utilities.CourseMarkers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course", schema = "public")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 30)
	public String name;
	
	@Column(name = "description", nullable = false, length = 300)
	public String description;
	
	@Column(name = "estimatehours", nullable = false, precision = 4)
	public Double estimateHours;
	
	@Column(name = "percentcomplete", nullable = false, precision = 4)
	public Double percentComplete;
	
	@Column(name = "demourl", nullable = false, length = 500)
	public String demoUrl;
	
	@OneToMany(mappedBy = "course")
	public List<CourseClass> classes = new ArrayList<>();
	
	//Find out how to deal with this DB-wise
	public Set<CourseMarkers> markers = new HashSet<>(); 
}

