package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.beans.CruiseShip;

@Repository
public interface CruiseShipRepo extends JpaRepository<CruiseShip, Long> {

}
