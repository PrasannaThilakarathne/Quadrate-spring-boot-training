package com.springAOP.spring;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
		System.out.println("hhhh");
	}
	
	@Bean
	@LogExecutionTime
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return ArgsAnnotationPointcut -> {
			Thread.sleep(100);
		};
	}

}
