package com.rizal.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Coach coach = context.getBean("volleyCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getFortune());
		
		context.close();
	}

}
