package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Car;
import com.example.facades.CarFacade;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	private CarFacade facade;

	@GetMapping()
	public List<Car> getAllCars() {
		return facade.getAllCars();
	}

	@GetMapping("{id}") // localhost:8080/cars/6
	public ResponseEntity<?> getCar(@PathVariable long id) { // ? generic to return any Type
		Car c = facade.getOneCar(id);
		if (c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
	}

	@PostMapping
	public void addCar(@RequestBody Car car) { // without requestbody localhost:8080?car=asdsdgasgd
		// with requestBody localhost:8080/ and lots of info including Car car
		//  look up wtf this is @RequestBody
		facade.addCar(car);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCar(@PathVariable long id) {
		try {
			facade.deleteCar(id);
			return ResponseEntity.ok("Car deleted");
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
		}
	}

	@PutMapping // put - update request
	public ResponseEntity<String> updateCar(@RequestBody Car car) {
		if (facade.updateCar(car)) {
			return ResponseEntity.ok("Car updated");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error updating car");
	}
}
