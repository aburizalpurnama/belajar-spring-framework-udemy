package com.rizal.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySoccerApp {

	public static void main(String[] args) {
		
		
		// get spring container
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from container
		SoccerCoach theCoach = context.getBean("soccerCoach", SoccerCoach.class);
		
		// get method from bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getFortune());
		
		System.out.println(theCoach.getCoachDetail());
		
		// close the context
		context.close();
	}

}
