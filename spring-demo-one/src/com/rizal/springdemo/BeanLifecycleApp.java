package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleApp {

	public static void main(String[] args) {
		
		// define spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// retrieve bean from container  
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		System.out.println(alphaCoach.getDailyWorkout());;
		
		// close the context
		context.close();
	}

}
