package com.fiap.codigo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.codigo.models.Course;
import com.fiap.codigo.repositories.CourseRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepo;
	
	@Transactional
	public Object save(@Valid Course course) {
		return courseRepo.save(course);
	}
	
	public List<Course> findAll() {
		return courseRepo.findAll();
	}
	
	public Object findById(int id) {
		return courseRepo.findById(id);
	}

	public Object findByName(String name) {
		return courseRepo.findByName(name);
	}
}
