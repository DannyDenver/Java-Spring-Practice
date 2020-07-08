package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

/*	@Bean
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
	}*/
}
