package com.ultrates.lab4springaop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4SpringAopApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){   //Note that you must aad modelMapper dependency to creat this method
		return  new ModelMapper();
	}
}
