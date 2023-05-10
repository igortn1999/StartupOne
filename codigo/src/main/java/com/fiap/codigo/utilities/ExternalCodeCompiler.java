package com.fiap.codigo.utilities;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ExternalCodeCompiler {
	
	public void compileCode();
	
	public static String determineExtension(File file){
		//REGEX:
		//\/([a-z A-z]*\.)([a-z A-z]*)
		if(file != null) {
			String filepath = file.toString();
			filepath= "/codigo/src/main/resources/templates/pythonTest.py";
			
			Pattern pattern = Pattern.compile("\\/([a-z A-z]*\\.)([a-z A-z]*)");
			Matcher matcher = pattern.matcher(filepath);
			
			if(matcher.find()) {
				String extension = matcher.group(2);//only get the third group which is the extension of the file (without the dot)
				System.out.println(extension);
				return extension;
			}
		}
		return null;
	}
}
