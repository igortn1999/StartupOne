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
	
//	List<Course> courses = new ArrayList<>();//TODO - Might have a better way to link Student - Course - Class
	
	@Column(name = "plantype", nullable = false)
	PlanType planType;
	
	@OneToMany(mappedBy = "student")
	List<StudentClassRegistration> classes = new ArrayList<>();//Linking ManyToMany relationship	
	
}
