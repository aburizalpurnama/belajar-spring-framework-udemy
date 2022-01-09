package com.rizal.springdemo;

public class BadmintonCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BadmintonCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Train a foot step for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
