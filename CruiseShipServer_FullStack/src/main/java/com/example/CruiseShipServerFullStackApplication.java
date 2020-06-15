package com.example;

import java.rmi.AlreadyBoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.beans.CruiseShip;
import com.example.beans.Passenger;
import com.example.services.CruiseShipService;

@SpringBootApplication
public class CruiseShipServerFullStackApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CruiseShipServerFullStackApplication.class, args);
		CruiseShipService s = ctx.getBean(CruiseShipService.class);
		try {
			s.createShip(1, 2, 3, "jeff");
			s.createShip(1, 2, 3, "jeff1");
			s.createShip(1, 2, 3, "jeff2");
			s.createShip(1, 2, 3, "jeff");
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		CruiseShip ship = new CruiseShip(1, 1, 3);
//		Passenger p = new Passenger("jeff", 1, null, null);
		
	}

}
