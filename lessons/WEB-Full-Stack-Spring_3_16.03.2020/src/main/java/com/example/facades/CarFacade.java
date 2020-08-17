package com.example.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Car;
import com.example.repos.CarsRepo;

@Service
public class CarFacade {
	@Autowired
	private CarsRepo repo; // if user says New CarFacade Autowired wont work but no compilation error - no
							// good

//	// better for other developers to not get confused and not do ctx.getbean
//	public CarFacade(CarsRepo carsRepo) { // no new repo needed
//		this.repo = carsRepo;
//	}

	public void addCar(Car car) {
		repo.save(car);
	}

	public boolean updateCar(Car car) {
		if (repo.existsById(car.getId())) {
			repo.save(car);
			return true;
		}
		return false;
	}

	public void deleteCar(long id) {
		repo.deleteById(id);
	}

	public List<Car> getAllCars() {
		return repo.findAll();
	}

	public Car getOneCar(long id) {
		return repo.findById(id).orElse(null);
	}
}
