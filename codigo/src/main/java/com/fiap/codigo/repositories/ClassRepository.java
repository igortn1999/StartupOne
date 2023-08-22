package com.fiap.codigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.codigo.models.CourseClass;

@Repository
public interface ClassRepository extends JpaRepository<CourseClass, Integer> {

	public CourseClass findById(int id);

//	public CourseClass findByName(String name);
}
