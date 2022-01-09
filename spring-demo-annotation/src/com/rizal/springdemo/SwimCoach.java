package com.rizal.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
	
		return "Swim for 100m twice !";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
