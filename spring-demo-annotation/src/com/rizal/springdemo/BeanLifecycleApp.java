package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleApp {
	public static void main(String[] args) {
		
		// load spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// get method from bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close container
		context.close();
	}
}
