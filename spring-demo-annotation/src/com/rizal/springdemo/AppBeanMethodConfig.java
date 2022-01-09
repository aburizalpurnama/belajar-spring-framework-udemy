package com.rizal.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanMethodConfig {
	
	// define bean for happyFortuneService
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for swimCoach, and inject dependency
	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach(happyFortuneService());
		return swimCoach;
	}
}
