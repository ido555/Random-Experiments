package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.beans.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

}
