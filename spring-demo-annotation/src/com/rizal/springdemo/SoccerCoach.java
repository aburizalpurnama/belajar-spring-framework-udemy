package com.rizal.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class SoccerCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "Running around stadium for 30 minutes";
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}
	
	public String getCoachDetail() {
		return "Coach detail : " + email + ", " + team;
	}

}
