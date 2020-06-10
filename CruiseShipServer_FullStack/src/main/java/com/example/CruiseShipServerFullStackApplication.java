package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.beans.CruiseShip;
import com.example.beans.Passenger;

@SpringBootApplication
public class CruiseShipServerFullStackApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CruiseShipServerFullStackApplication.class, args);
//		CruiseShip ship = new CruiseShip(1, 1, 3);
//		Passenger p = new Passenger("jeff", 1, null, null);
		
	}

}
