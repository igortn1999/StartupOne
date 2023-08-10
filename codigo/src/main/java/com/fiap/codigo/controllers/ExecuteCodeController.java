package com.fiap.codigo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExecuteCodeController {

    @PostMapping("/run_code")
    public String runCode(@RequestBody StudentSubmission data) {
        // Process the received data
		String code = data.getCode();

		// Convert the new DataObject to JSON string
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = objectMapper.writeValueAsString(code);

		// Return the JSON string
		return code;

        //return null;
    }

    // DataObject class to represent the JSON structure
    private static class StudentSubmission {
        private String code;
        private String tests;

        // Getters and setters
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTests() {
            return tests;
        }

    }
}