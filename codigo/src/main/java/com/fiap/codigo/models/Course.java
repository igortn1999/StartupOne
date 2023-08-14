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
	
//	@Column(name = "percentcomplete", nullable = false, precision = 4) //TODO - Should this be tracked by the StundentClassRegistration table?
//	public Double percentComplete; 
	
	@Column(name = "demourl", nullable = false, length = 500)
	public String demoUrl;
	
	@OneToMany(mappedBy = "course")
	public List<CourseClass> classes = new ArrayList<>();
	
	//Find out how to deal with this DB-wise
	public Set<CourseMarkers> markers = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getEstimateHours() {
		return estimateHours;
	}

	public void setEstimateHours(Double estimateHours) {
		this.estimateHours = estimateHours;
	}

	public String getDemoUrl() {
		return demoUrl;
	}

	public void setDemoUrl(String demoUrl) {
		this.demoUrl = demoUrl;
	}

	public List<CourseClass> getClasses() {
		return classes;
	}

	public void setClasses(List<CourseClass> classes) {
		this.classes = classes;
	}

	public Set<CourseMarkers> getMarkers() {
		return markers;
	}

	public void setMarkers(Set<CourseMarkers> markers) {
		this.markers = markers;
	} 
	
	
	
}
