package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {

}
