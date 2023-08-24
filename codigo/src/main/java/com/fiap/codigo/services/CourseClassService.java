package com.fiap.codigo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.codigo.models.Course;
import com.fiap.codigo.models.CourseClass;
import com.fiap.codigo.repositories.CourseClassRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CourseClassService {
	
	@Autowired
	CourseClassRepository classRepo;
	
	@Transactional
	public void save(@Valid CourseClass courseClass) {
		classRepo.save(courseClass);
	}
	
	public Object findAll() {
		return classRepo.findAll();
	}
	
	public Object findById(int id) {
		return classRepo.findById(id);
	}

	public Object findByParentId(int course_id) {
		return classRepo.findBycourse_id(course_id);
	}

}
