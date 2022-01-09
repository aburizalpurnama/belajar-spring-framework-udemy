package com.rizal.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJudoApp {

	public static void main(String[] args) {
		
		// load spring container
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppJudoConfig.class);
		
		// retrieve bean from container
		Coach coach = context.getBean("judoCoach", Coach.class);
		
		// execute bean method
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		// close the container
		context.close();
	}

}
