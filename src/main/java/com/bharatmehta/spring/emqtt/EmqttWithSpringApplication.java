package com.bharatmehta.spring.emqtt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MqttConfiguration.class)
public class EmqttWithSpringApplication {
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(EmqttWithSpringApplication.class, args);
	}
}
