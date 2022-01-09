package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {
		
		// define spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from container
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		Coach deltaCoach = context.getBean("myCoach", Coach.class);
		
		// compare if those beans are the same
		boolean result = (alphaCoach == deltaCoach);
		
		// print the result
		System.out.println("Is booth are same object ? :" + result);
		
		System.out.println("memory location for alphaCoach : " + alphaCoach);
		
		System.out.println("memory location for deltaCoach : " + deltaCoach);
		
		// close the context
		context.close();
	}

}
