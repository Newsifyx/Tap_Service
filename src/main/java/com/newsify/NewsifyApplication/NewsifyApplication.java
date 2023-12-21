package com.newsify.NewsifyApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.newsify.entity")
@EnableJpaRepositories(basePackages = "com.newsify.repository")
@ComponentScan(basePackages = { "com.newsify.controller", "com.newsify.service", "com.newsify.vo" })
public class NewsifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsifyApplication.class, args);
	}

}
