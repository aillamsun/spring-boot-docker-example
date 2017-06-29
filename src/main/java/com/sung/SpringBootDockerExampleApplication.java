package com.sung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootDockerExampleApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootDockerExampleApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootDockerExampleApplication.class);
		app.run(args);
	}

}
