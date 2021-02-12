package com.example.services;

import java.rmi.AlreadyBoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.CruiseShip;
import com.example.beans.Passenger;
import com.example.enums.BookingStatus;
import com.example.repositories.CruiseShipRepo;

@Service
public class CruiseShipService {
	@Autowired
	CruiseShipRepo repo;
	
	public void createShip(int numOfDecks, int numOfPools, int numOfRooms, String name) throws AlreadyBoundException {
		for (CruiseShip ship : repo.findAll()) {
			if (ship.getName().equals(name)) {
				throw new AlreadyBoundException("this name already exists");
			}
		}
		repo.save(new CruiseShip(numOfDecks, numOfPools, numOfRooms, name));
	}
	
	public void deleteShip(CruiseShip ship) {
		for (Passenger pass: ship.getPassengers()) {
			pass.setShip(null);
			pass.setStatus(BookingStatus.Pending);
		}
		repo.delete(ship);
	}
}
