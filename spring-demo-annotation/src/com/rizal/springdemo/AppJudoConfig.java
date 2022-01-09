package com.rizal.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppJudoConfig {
	
	@Bean
	public FortuneService spiritFortuneService() {
		return new SpiritFortuneService();
	}
	
	@Bean
	public Coach judoCoach() {
		Coach coach = new JudoCoach(spiritFortuneService());
		return coach;
	}
}
