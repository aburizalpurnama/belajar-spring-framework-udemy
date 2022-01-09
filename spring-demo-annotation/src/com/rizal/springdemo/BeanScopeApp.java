package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {
		
		// load spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get beans that will be compared from container 
		Coach alphaCoach = context.getBean("soccerCoach", Coach.class);
		
		Coach deltaCoach = context.getBean("soccerCoach", Coach.class);
		
		// describe beans
		System.out.println("alphaBean location :" + alphaCoach);
		
		System.out.println("deltaBean location :" + deltaCoach);
		
		// check are beans the same
		System.out.println("Is the same bean : " + (alphaCoach == deltaCoach));
		
		// close spring container
		context.close();
	}
}
