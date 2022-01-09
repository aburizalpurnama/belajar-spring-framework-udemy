package com.rizal.springdemo;

public class TrackCoach implements Coach {
	
	// define dependency
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public TrackCoach() {
		System.out.println("TrackCoach : no args constructor");
	}
	
	// add an init method
	public void doMySetupStuff() {
		System.out.println("TrackCoach : init method");
	}
	
	// add an destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : destroy method");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach daily fortune : " + fortuneService.getFortune();
	}
	
	// define setter method for dependency object that called by spring during do setter injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("TrackCoach : setter method of fortuneService");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("TrackCoach : setter method of emailAddress");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("TrackCoach : setter method of team");
	}

}
