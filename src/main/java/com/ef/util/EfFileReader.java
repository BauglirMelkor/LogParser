package com.ef.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ef.processor.ParserProcessor;

@Component
public class EfFileReader {
	
	private final ParserProcessor parserProcessor;
	
	@Autowired
	public EfFileReader(ParserProcessor parserProcessor){
		this.parserProcessor=parserProcessor;	
	}
	
	public void getFile(String fileName) throws ParseException {	
		ClassLoader classLoader = EfFileReader.class.getClassLoader();
		Path filePath = Paths.get(classLoader.getResource(fileName).getPath());

		try (InputStream in = Files.newInputStream(filePath);
			    BufferedReader reader =
			      new BufferedReader(new InputStreamReader(in))) {
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			    	parserProcessor.parseLine(line);
			    }
			} catch (IOException x) {
			    System.err.println(x);
			}
	  }

}
