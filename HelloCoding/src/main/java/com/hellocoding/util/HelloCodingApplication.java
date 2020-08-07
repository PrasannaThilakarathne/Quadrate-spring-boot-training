package com.hellocoding.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jdk.internal.org.jline.utils.Log;

@SpringBootApplication
public class HelloCodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloCodingApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(SimpleProperties simpleProperties, NestedProperties nestedProperties) {
		return r->{
			Log.info(simpleProperties.getA());
			Log.info(nestedProperties.getA().getB());
		};
	}

}
