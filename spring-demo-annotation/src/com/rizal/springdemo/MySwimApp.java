package com.rizal.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MySwimApp {

	public static void main(String[] args) {
		
		// load spring container
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppBeanMethodConfig.class);
		
		// retrieve bean from container
		Coach coach = context.getBean("swimCoach", Coach.class);
 
		// run method from bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		// close the container
		context.close();
		
	}

}
