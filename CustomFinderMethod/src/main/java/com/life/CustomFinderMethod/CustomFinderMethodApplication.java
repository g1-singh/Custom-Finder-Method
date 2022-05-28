package com.life.CustomFinderMethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class CustomFinderMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomFinderMethodApplication.class, args);
		
		System.out.println("Starting Code");
	}

}
