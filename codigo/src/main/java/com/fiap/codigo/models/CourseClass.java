package com.fiap.codigo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Courseclass", schema = "public")
public class CourseClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@NotNull
	public Course course;
	
	@Column(name = "name", nullable = false, unique = true, length = 40)
	public String name;
	
	@Column(name = "details", nullable = false, length = 1000)
	public String details;
	
	@Column(name = "estimatehours", nullable = false, precision = 4)
	public Double estimateHours;
	
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
	
//	@OneToMany(mappedBy = "courseClass")//DO NOT USE THIS IN JAVA SPRING!!! Memory leak!
//	List<StudentClassRegistration> students = new ArrayList<>();
	

	public CourseClass() {
		//The framework will take care of creating and setting models.
		//Just a empty builder will handle the problem
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Double getEstimateHours() {
		return estimateHours;
	}

	public void setEstimateHours(Double estimateHours) {
		this.estimateHours = estimateHours;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getCodeExample() {
		return codeExample;
	}

	public void setCodeExample(String codeExample) {
		this.codeExample = codeExample;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

//	public List<StudentClassRegistration> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<StudentClassRegistration> students) {
//		this.students = students;
//	}

}
