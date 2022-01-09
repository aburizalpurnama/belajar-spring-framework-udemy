package com.rizal.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyVolleyApp {

	public static void main(String[] args) {
		
		// get spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from container
		Coach thecoach = context.getBean("volleyCoach", Coach.class);

		// run method from bean
		System.out.println(thecoach.getDailyWorkout());
		
		System.out.println(thecoach.getFortune());
		
		// close the spring container
		context.close();
	}

}
