package com.fiap.codigo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.codigo.models.Course;
import com.fiap.codigo.repositories.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository cr;
	
	@Transactional
	public Object save(Course course) {
		return cr.save(course);
	}
	
	public Object findAll() {
		return cr.findAll();
	}
	
	public Object findById(int id) {
		return cr.findById(id);
	}

	public Object findByName(String name) {
		return cr.findByName(name);
	}
}
