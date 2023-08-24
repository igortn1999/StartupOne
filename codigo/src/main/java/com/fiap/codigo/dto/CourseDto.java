package com.fiap.codigo.dto;

import java.util.Set;
import java.util.List;

import com.fiap.codigo.models.CourseClass;
import com.fiap.codigo.utilities.CourseMarkers;

public class CourseDto {
	
	public int id;
	public String name;
	public String description;
	public Double estimateHours;
	public String demoUrl;
	public List<CourseClass> classes;
	public Set<CourseMarkers> markers;
	
	public CourseDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Set<CourseMarkers> getMarkers() {
		return markers;
	}

	public void setMarkers(Set<CourseMarkers> markers) {
		this.markers = markers;
	}

}
