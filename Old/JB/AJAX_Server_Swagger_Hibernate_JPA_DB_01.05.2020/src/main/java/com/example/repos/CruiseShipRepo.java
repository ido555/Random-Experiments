package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.CruiseShip;

public interface CruiseShipRepo extends JpaRepository<CruiseShip, Long>{
	boolean existsByName(String name);
	CruiseShip findByName(String name);
}
