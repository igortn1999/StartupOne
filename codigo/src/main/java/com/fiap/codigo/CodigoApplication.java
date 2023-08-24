package com.fiap.codigo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.fiap.codigo.models.Course;
import com.fiap.codigo.models.CourseClass;
import com.fiap.codigo.repositories.CourseClassRepository;
import com.fiap.codigo.repositories.CourseRepository;

@SpringBootApplication
public class CodigoApplication {
	
	@Autowired
	private  CourseRepository courseRepo;
	
	@Autowired
	private  CourseClassRepository classRepo;

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
		
		Course course = new Course();
		
		course.setName("Python");
		course.setDescription("Learn python today!");
		course.setEstimateHours(50.0);
		course.setDemoUrl("www.google.com");
	
		courseRepo.save(course);
		
//		CourseClass courseClass1 = new CourseClass(course, "Variables", "learn how to use variables in python!", 0.1, "www.google.com", "INSERT CODE EXAMPLE HERE", new Date(), "Python", "create a code with variables");
//		CourseClass courseClass2 = new CourseClass(course, "Arrays", "learn how to use arrays in python!", 0.3, "www.google.com", "INSERT CODE EXAMPLE HERE (Again)", new Date(), "Python", "create a code with arrays");
		
		CourseClass courseClass1 = new CourseClass();
		CourseClass courseClass2 = new CourseClass();
		
		courseClass1.setCourse(course);
		courseClass1.setName("Variables");
		courseClass1.setDetails("learn how to use variables in python!");
		courseClass1.setEstimateHours(0.1);
		courseClass1.setVideoUrl("www.google.com");
		courseClass1.setCodeExample("INSERT CODE EXAMPLE HERE");
		courseClass1.setPublishDate(new Date());
		courseClass1.setLang("Python");
		courseClass1.setTask("create a code with variables");

		courseClass2.setCourse(course);
		courseClass2.setName("Arrays");
		courseClass2.setDetails("learn how to use arrays in python!");
		courseClass2.setEstimateHours(0.3);
		courseClass2.setVideoUrl("www.google.com");
		courseClass2.setCodeExample("INSERT CODE EXAMPLE HERE");
		courseClass2.setPublishDate(new Date());
		courseClass2.setLang("Python");
		courseClass2.setTask("create a code with arrays");
		
		classRepo.save(courseClass1);
		classRepo.save(courseClass2);
		
	}

}
