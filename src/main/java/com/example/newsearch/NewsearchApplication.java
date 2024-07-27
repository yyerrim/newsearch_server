package com.example.newsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsearchApplication.class, args);
	}

}
