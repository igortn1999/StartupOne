package com.fiap.codigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.codigo.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public Course findById(int id);

	public Course findByName(String name);
	
//	public List<Course> findby

}
