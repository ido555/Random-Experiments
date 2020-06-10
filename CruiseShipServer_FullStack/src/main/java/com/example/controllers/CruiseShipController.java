package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ship")
@CrossOrigin(origins = "http://localhost:4200")
public class CruiseShipController {

	@GetMapping("{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		return null;
	}

}
