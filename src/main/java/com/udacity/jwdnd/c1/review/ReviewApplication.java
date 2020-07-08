package com.udacity.jwdnd.c1.review;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	public String message() {
		return "Hello, Spring";
	}

	@Bean
	public String uppercaseMessage(MessageService messageService) {
		String upper = messageService.upperCase();
		System.out.println(upper);
		return upper;
	}

	@Bean
	public String lowercaseMessage(MessageService messageService) {
		String lower = messageService.lowerCase();
		System.out.println(lower);
		return lower;
	}
}
