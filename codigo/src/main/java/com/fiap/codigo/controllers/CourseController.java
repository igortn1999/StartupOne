package com.fiap.codigo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.codigo.models.CodeRequest;
import com.fiap.codigo.services.CourseClassService;
import com.fiap.codigo.services.CourseService;
import com.fiap.codigo.services.ExecuteCodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		List<Boolean> challenges = new ArrayList<>();

		String result = executeCodeService.executeCode(codeRequest.getCode());

		String regexPattern;
		String errorMessage;

		if(lessonId==1){

			//Checador variável com string
			regexPattern = "\\w.*= ?\\\".*\\\"";
			errorMessage = "Você colocou aspas no codigo?";

			//0 - Variavel com a idade
			challenges.add(false);

			//1 - Variavel com o nome
			challenges.add(false);




		}else{
			regexPattern = "\\w.*=\\s*\\[\\\"([^\\\"]+)\\\"(?:\\s*,\\s*\\\"([^\\\"]+)\\\")*\\]";
			errorMessage = "Você fez uma lista com os caracteres '[' e ']' ?";
			challenges.add(false);
		}

		if("regex".equals(validationType)){


			if(lessonId==1){
				//Checador variavel com idade
				String regexPattern2 = "\\w.*= ?\\d{1,2}";
				Pattern pattern2 = Pattern.compile(regexPattern2, Pattern.CASE_INSENSITIVE);
				Matcher matcher2 = pattern2.matcher(code);
				boolean matchFound2 = matcher2.find();


				//Checando por variavel com idade
				if (matchFound2) {
					challenges.set(1, true);
				}

			}


			Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(code);
			boolean matchFound = matcher.find();

			if (matchFound) {
				challenges.set(0, true);
				CodeResponse customResponse = new CodeResponse(null, result, challenges);


				return ResponseEntity.ok(customResponse);
			}
			else {
				CodeResponse customResponse = new CodeResponse(errorMessage, result, challenges);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
			}

		}else{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bad call");
		}

	}

}
