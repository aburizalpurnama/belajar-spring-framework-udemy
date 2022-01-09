package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBoxingApp {

	public static void main(String[] args) {
		
		// get spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from spring container
		Coach theCoach = context.getBean("boxingCoach", Coach.class);
		
		// get method from bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		
		// close the context
		context.close();
		
	}

}
