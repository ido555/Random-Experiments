package com.example.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.beans.CruiseShip;
import com.example.exceptions.NameAlreadyInUseException;
import com.example.repos.CruiseShipRepo;

@Service
public class CruiseShipFacade {
	@Autowired
	CruiseShipRepo repo;
	public void addShip(CruiseShip ship) throws NameAlreadyInUseException {
		if (repo.existsByName(ship.getName())) {
			throw new NameAlreadyInUseException();
		}
	}
}
