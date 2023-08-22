package com.fiap.codigo.models;

import java.util.ArrayList;
import java.util.List;

import com.fiap.codigo.utilities.PlanType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student", schema = "public")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable = false, length = 70)
	public String email;
	
	@Column(name = "password", nullable = false, length = 120)
	public String password;
	
	@Column(name = "name", nullable = false, length = 50)
	public String name;
	
	@Column(name = "lastname", nullable = false, length = 50)
	public String lastname;
	
	@Column(name = "active", nullable = false)
	boolean isActive = false;
	
	@Column(name = "plantype", nullable = false)
	PlanType planType;
	
//	@OneToMany(mappedBy = "student")//DO NOT USE THIS IN JAVA SPRING!!! Memory leak!
//	List<StudentClassRegistration> classeRegistrations = new ArrayList<>();//Linking ManyToMany relationship	

//	List<Course> courses = new ArrayList<>();//TODO - Might have a better way to link Student - Course - Class
	
	public Student() {
		
	}
	
//	public Student(String email, String password, String name, String lastname, boolean isActive, PlanType planType, List<StudentClassRegistration> classeRegistrations) {
	public Student(String email, String password, String name, String lastname, boolean isActive, PlanType planType) {
		this.email = email;
		setPassword(password);
		this.name = name;
		this.lastname = lastname;
		this.isActive = isActive;
		this.planType = planType;
//		setClasses(classeRegistrations);
	}
	
	public Student(String email, String password, String name, String lastname) {
		this.email = email;
		setPassword(password);
		this.name = name;
		this.lastname = lastname;
		this.isActive = true;
		this.planType = PlanType.NORMAL;
		//classRegistrations attribute is already instaciated with a empty list
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;//TODO - must get the encrypted password stored in the database
	}

	public void setPassword(String password) {
		this.password = password;//TODO - must encrypt password before storing in database
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

//	public List<StudentClassRegistration> getClasses() {
//		return classeRegistrations;
//	}
//
//	public void setClasses(List<StudentClassRegistration> classeRegistrations) {
//		if(classeRegistrations != null) {
//			this.classeRegistrations = classeRegistrations;
//		}
//	}
	
//	public void addClassRegistration(StudentClassRegistration classRegistration) {
//		getClasses().add(classRegistration);
//	}
//	
//	public void addClassRegistrations(List<StudentClassRegistration> classes) {
//		classes.stream().forEach(cr -> this.addClassRegistration(cr));
//	}
	
}
