package com.fiap.codigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.codigo.services.CourseService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	CourseService cs;
	
	@GetMapping
	public ResponseEntity<Object> getCourses(){
		return ResponseEntity.status(HttpStatus.OK).body(cs.findAll());
	}
	
	@GetMapping(path = "/id")//http://localhost:8080/api/courses/id?id=1
	public ResponseEntity<Object> findCourseById(@RequestParam(name = "id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(cs.findById(id));
	}
	
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<Object> findCourseByName(@RequestParam String name){
		return ResponseEntity.status(HttpStatus.OK).body(cs.findByName(name));
	}
	
//	@GetMapping(path = "/id/{id}/classes")
//	public ResponseEntity<Object> getCourseClasses(@PathVariable int id){
//		Object course = cs.findById(id);
//		if( course == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
//		}
		
		
//		List<CourseClass> classes = ((Course) course).getClasses();
//		return ResponseEntity.status(HttpStatus.OK).body(classes);
//	}
	
//	@GetMapping(path = "/classes/{className}")
//	public ResponseEntity<Object> find

}
