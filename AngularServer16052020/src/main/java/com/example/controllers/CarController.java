package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Car;
import com.example.repos.CarRepo;

@RestController
@RequestMapping("cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
	@Autowired
	CarRepo repo;

	@GetMapping
	public List<Car> getAllCars() {
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		// no reposneEntity error checking stuff
		if(repo.findById(id).orElse(null) != null) {
			return ResponseEntity.ok(repo.findById(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no car with that id was found");
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCar(@RequestBody Car car) {
		System.out.println("trying to add car");
		try {
			repo.save(car);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok("car added");
	}
}
