package com.rizal.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("randomFortuneService")
	public void injectField(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Train jump smash for 90 minutes";
	}
	
	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}

}
