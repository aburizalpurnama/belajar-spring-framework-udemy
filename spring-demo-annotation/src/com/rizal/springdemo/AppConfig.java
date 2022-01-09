package com.rizal.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.rizal.springdemo")
@PropertySource("classpath:sport.properties")
public class AppConfig {
	
}
