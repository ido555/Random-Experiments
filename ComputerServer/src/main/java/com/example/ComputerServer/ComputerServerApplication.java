package com.example.ComputerServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ComputerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerServerApplication.class, args);
		
		// RestTemplate is deprecated
		RestTemplate request = new RestTemplate();
		
	}

}
