
package com.life.CustomFinderMethod.swagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {

		/*
		 * return new
		 * Docket(DocumentationType.SWAGGER_2).groupName("rakuten").apiInfo(apiInfo()).
		 * select()
		 * 
		 * .paths(regex("/api.*")).build();
		 */

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.rakuten.CustomFinderMethod"))
				.paths(regex("/api.*")).build();

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Event API")
				.description("API Documentation Generateed Using SWAGGER2 for our Course Rest API").version("1.0")
				.build();

	}

}