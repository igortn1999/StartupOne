package com.fiap.codigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.codigo.models.CodeRequest;
import com.fiap.codigo.services.CourseClassService;
import com.fiap.codigo.services.CourseService;
import com.fiap.codigo.services.ExecuteCodeService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fiap.codigo.models.CodeResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseClassService courseClassService;

	@Autowired
	ExecuteCodeService executeCodeService;
	
	@GetMapping
	public ResponseEntity<Object> getCourses(){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
	}
	
	@GetMapping(path = "/id/{id}")//http://localhost:8080/api/courses/id/1
	public ResponseEntity<Object> findCourseById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(id));
	}
	
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<Object> findCourseByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.OK).body(courseService.findByName(name));
	}
	
	@GetMapping(path = "/id/{id}/classes")
	public ResponseEntity<Object> getCourseClasses(@PathVariable int id){
		Object course = courseService.findById(id);
		if(course == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(courseClassService.findByParentId(id));
	}

	@PostMapping(path="/validate")
	public ResponseEntity<Object> validateCode(@RequestBody CodeRequest codeRequest){
		String validationType = codeRequest.getValidationType();
		int lessonId = codeRequest.getLessonId();
		String code = codeRequest.getCode();

		System.out.println(validationType);
		System.out.println(lessonId);
		System.out.println(code);
		String regexPattern;
		String errorMessage;

		if(lessonId==1){
			regexPattern = "\\w.*= ?\\\".*\\\"";
			errorMessage = "Você colocou aspas no codigo?";

		}else{
			regexPattern = "\\[.*\\]";
			errorMessage = "Você fez uma lista com os caracteres '[' e ']' ?";
		}

		if("regex".equals(validationType)){
			Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(code);
			boolean matchFound = matcher.find();

			if (matchFound) {
				System.out.println("Exercício Correto");
				String result = executeCodeService.executeCode(codeRequest.getCode());
				CodeResponse customResponse = new CodeResponse(null, result);
				return ResponseEntity.ok(customResponse);
			} else {
				String result = executeCodeService.executeCode(codeRequest.getCode());
				CodeResponse customResponse = new CodeResponse(errorMessage, result);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
			}

		}else{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bad call");
		}

	}

}
