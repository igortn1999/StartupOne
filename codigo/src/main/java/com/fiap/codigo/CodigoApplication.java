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
		boolean mock = true;
		
		if(mock) {
			mockData();
		}
	}
	
	private void mockData() {
		Course course = mockCourse("Python", "Learn python today!", 50.0, "DXmCU7v9glM", "");
		
		String class1details = "O curso Python, do zero ao avançado é um curso completo para quem deseja aprender Python e se tornar um desenvolvedor com conhecimentos intermediários. O curso é ministrado pelo professor John Doe, é atualizado com a última versão do, Python 3.11 e inclui 10 cases reais para ajudar você a desenvolver as habilidades de programação.";
		String class1Code = "#Escreva seu codigo abaixo\r\n"
						  + "idade=12\r\n"
						  + "\r\n"
						  + "nome = \"John Doe\"";
		String class1Task = "Crie uma variável com a sua idade, Crie uma variável com o seu nome";
		
		CourseClass class1 = mockClass(course, "introdução", class1details, 0.25, "BW9Va5syNC0", class1Code, new Date(), "Python", class1Task);	
		
		
		
		String class2details = "learn how to use arrays in python!" ;
		String class2Code = "Não há codigo, apenas veja esta receita da palmirinha!";
		String class2Task = "Faça sua propria receita com a palmirinha!";
		
		CourseClass class2 = mockClass(course, "Arrays", class2details, 0.5, "RfCUO02nWGY", class2Code, new Date(), "Python", class2Task);		
	}
	
	private Course mockCourse(String name, String description, double estimateHours, String overviewUrl, String image) {
		Course course = new Course();
		
		course.setName(name);
		course.setDescription(description);
		course.setEstimateHours(estimateHours);
		course.setOverviewUrl(overviewUrl);
		course.setImage(image);
		
		courseRepo.save(course);
		
		return course;
	}
	
	private CourseClass mockClass(Course course, String name, String details, double estimateHours, String videoUrl, String codeExample, Date publishDate, String lang, String task) {
		CourseClass courseClass = new CourseClass();
		
		courseClass.setCourse(course);
		courseClass.setName(name);
		courseClass.setDetails(details);
		courseClass.setEstimateHours(estimateHours);
		courseClass.setVideoUrl(videoUrl);
		courseClass.setCodeExample(codeExample);
		courseClass.setPublishDate(publishDate);
		courseClass.setLang(lang);
		courseClass.setTask(task);
		
		classRepo.save(courseClass);

		return courseClass;
	}

}
