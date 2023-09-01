package com.fiap.codigo.models;

import java.util.HashSet;
import java.util.Set;

import com.fiap.codigo.utilities.CourseMarkers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course", schema = "public")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "name", nullable = false, unique = true, length = 30)
	public String name;
	
	@Column(name = "description", nullable = false, length = 300)
	public String description;
	
	@Column(name = "estimatehours", nullable = false, precision = 4)
	public Double estimateHours;
	
	@Column(name = "overviewUrl", nullable = false, length = 500)
	public String overviewUrl;
	
	@Column(name = "image", nullable = false, length = 500)
	public String image;
	
//	@OneToMany(mappedBy = "course")//DO NOT USE THIS IN JAVA SPRING!!! Memory leak!
//	public List<CourseClass> classes = new ArrayList<>();
	
	//TODO - Find out how to deal with this DB-wise
	public Set<CourseMarkers> markers = new HashSet<>();

	public Course() {
		//The framework will take care of creating and setting models.
		//Just a empty builder will handle the problem
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

//	public List<CourseClass> getClasses() {
//		return classes;
//	}
//
//	public void setClasses(List<CourseClass> classes) {
//		if(classes != null) {			
//			this.classes = classes;
//		}
//	}
	
//	public void addClass(CourseClass courseClass) {
//		getClasses().add(courseClass);
//	}
//	
//	public void addClasses(List<CourseClass> classes) {
//		classes.stream().forEach(cc -> addClass(cc));
//	}

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
	
}

