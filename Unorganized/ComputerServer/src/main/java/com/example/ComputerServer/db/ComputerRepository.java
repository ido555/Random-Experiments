package com.example.ComputerServer.db;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.ComputerServer.beans.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

	@Query(value = "select c from Computer c where c.model = 'HP' or c.model = 'Asus'")
	List<Computer> findBySomething();
	
	@Query(nativeQuery = true, value = "select * from computers where model = 'HP' or model = 'Asus'")
	List<Computer> findBySomething2();
	
	@Query(value = "select c from Computer c where c.model =:model")
//	@Transactional
//	@Modifying
	List<Computer> findByModel(String model);
	
}
