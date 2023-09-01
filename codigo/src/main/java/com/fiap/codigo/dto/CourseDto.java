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
	public String overviewUrl;
	public String image;
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

	public String getOverviewUrl() {
		return overviewUrl;
	}

	public void setOverviewUrl(String overviewUrl) {
		this.overviewUrl = overviewUrl;
	}

	public Set<CourseMarkers> getMarkers() {
		return markers;
	}

	public void setMarkers(Set<CourseMarkers> markers) {
		this.markers = markers;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<CourseClass> getClasses() {
		return classes;
	}

	public void setClasses(List<CourseClass> classes) {
		this.classes = classes;
	}
	
	

}
