package com.rizal.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${data.fortune}")
	private String filename;
	
	// instance object list of fortunes
	private List<String> fortunes = new ArrayList<String>();
	
	@Override
	public String getFortune() {
		
		Random random = new Random();
		
		return fortunes.get(random.nextInt(fortunes.size()));
	}
	
	@PostConstruct
	public void retrieveFortunesFromFile() {
		
		// define filePath
//		String filePath = "/home/rizal/Documents/Java-Projects/spring-demo-annotation/src/data-fortunes.txt";
				
		// create file object from file path
		File file = getFilePath(filename);
		System.out.println("RandomFortuneService.getFortune() : Reading fortunes from file : " + file);
		System.out.println("RandomFortuneService.getFortune() : Is file exist : " + file.exists());		
				
		// read fortune from file
		try (
			BufferedReader br = new BufferedReader(new FileReader(file))
			){
					
			// insert each line of file to list of fortunes
			String tempLine;
			while((tempLine = br.readLine()) != null) {
				fortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(">> RandomFortuneService.retrieveFortunesFromFile() : do some start up stuff with @PostConstruct Annotation");
	}
	
	private File getFilePath(String filename) {
		
		File file = null;
		
		URL resource = getClass().getClassLoader().getResource(filename);
		try {
			file = Paths.get(resource.toURI()).toFile();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
	
}
