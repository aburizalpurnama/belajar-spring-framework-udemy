package com.rizal.springdemo;

public class JudoCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public JudoCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "fight with another athlete !";
	}

	@Override
	public String getFortune() {
		
		return fortuneService.getFortune();
	}

}
