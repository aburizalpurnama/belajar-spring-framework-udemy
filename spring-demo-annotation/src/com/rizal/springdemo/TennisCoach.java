package com.rizal.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@PostConstruct
	public void doStartupStuff() {
		System.out.println("TennisCoach.doStartStuff() : do some start up stuff in bean");
	}
	
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("TennisCoach.doCleanupStuff() : do some clean up stuff in bean");
	}

	@Override
	public String getDailyWorkout() {
	
		return "Run around field for 30 minutes";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
