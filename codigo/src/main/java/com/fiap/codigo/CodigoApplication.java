package com.fiap.codigo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.fiap.codigo.models.Course;
import com.fiap.codigo.models.CourseClass;
import com.fiap.codigo.repositories.ClassRepository;
import com.fiap.codigo.repositories.CourseRepository;

@SpringBootApplication
public class CodigoApplication {
	
	@Autowired
	private  CourseRepository courseRepo;
	
	@Autowired
	private  ClassRepository classRepo;

	public static void main(String[] args) {
		SpringApplication.run(CodigoApplication.class, args);
	}
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		boolean mock = false;
		
		if(mock) {
			mockData();
		}
	}
	
	private void mockData() {
		
		Course course = new Course("Python", "Learn python today!", 50.0, "www.google.com"); 
	
		courseRepo.save(course);
		
		CourseClass courseClass1 = new CourseClass(course, "Variables", "learn how to use variables in python!", 0.1, "www.google.com", "INSERT CODE EXAMPLE HERE", new Date(), "Python", "create a code with variables");
		CourseClass courseClass2 = new CourseClass(course, "Arrays", "learn how to use arrays in python!", 0.3, "www.google.com", "INSERT CODE EXAMPLE HERE (Again)", new Date(), "Python", "create a code with arrays");
		
		courseClass1.setCourse(course);
		courseClass2.setCourse(course);
		
		classRepo.save(courseClass1);
		classRepo.save(courseClass2);
		
	}

}
