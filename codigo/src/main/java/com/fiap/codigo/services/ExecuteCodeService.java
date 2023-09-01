package com.fiap.codigo.services;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;


@Service
public class ExecuteCodeService {

    public String executeCode(String code) {
        try {
            // Create a new process to run the Python code
            ProcessBuilder processBuilder = new ProcessBuilder("python3","-u", "-c", code);
            Process process = processBuilder.start();

            // Read the output of the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();

            System.out.println("Codigo");
            System.out.println(output);

            if (exitCode == 0) {
                System.out.println("Codigo Zero");
                return output.toString();
            } else {
                // Handle the case where the Python script has an error
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                StringBuilder errorOutput = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorOutput.append(errorLine).append("\n");
                }
                return "Python script error:\n" + errorOutput.toString();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error executing Python code: " + e.getMessage();
        }
    }
}