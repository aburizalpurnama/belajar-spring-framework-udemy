package com.rizal.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {
			"Just Do It!",
			"Train Hard Play Hard",
			"Do Your Best!"};

	@Override
	public String getFortune() {
		
		// define random object to get random number
		Random random = new Random();
		int randomNumber = random.nextInt(fortunes.length);
		
		return fortunes[randomNumber];
	}

}
