package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.CruiseShip;

public interface CruiseShipRepo extends JpaRepository<CruiseShip, Long> {

}
