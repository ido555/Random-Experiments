package com.example.ComputerServer;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.ComputerServer.beans.Computer;

@SpringBootApplication
public class ComputerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerServerApplication.class, args);
		
		// RestTemplate is deprecated
		RestTemplate request = new RestTemplate();
		// get entity when the object is an exact match to Computer.class
		// get object otherwise
		try {
//		ResponseEntity<Computer> c1 = request.getForEntity("http://localhost:8080/comp/142424", Computer.class);
//		System.out.println("status code: " + c1.getStatusCode());
//		System.out.println(c1);
		
		ResponseEntity<Computer[]> computers = request.getForEntity("http://localhost:8080/comp", Computer[].class);
		
		Computer comp = new Computer("model123", 12, 504.9);
		
		// returns ResponseEntity<Computer>
		request.postForEntity("http://localhost:8080/comp", comp, Computer.class);
			System.out.println(Arrays.toString(computers.getBody()));
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
		}
	}

}
