package com.example.repos;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.Car;

@Repository
@Transactional
public interface CarRepo extends JpaRepository<Car, Long>{
}
