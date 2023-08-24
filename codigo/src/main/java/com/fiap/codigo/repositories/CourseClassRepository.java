package com.fiap.codigo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.codigo.models.CourseClass;

@Repository
public interface CourseClassRepository extends JpaRepository<CourseClass, Integer> {

	public CourseClass findById(int id);
	
	public List<Object> findBycourse_id(int course_id);

}
