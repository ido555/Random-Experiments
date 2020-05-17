package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Car;

public interface CarRepo extends JpaRepository<Car, Long>{

}
