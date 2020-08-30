package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beans.Drink;

// =partial= error checking
@RestController
@RequestMapping("drinks")
public class AJAX_Drink_Controller {
	// List instead of DB to simplify stuff
	private ArrayList<Drink> drinks = new ArrayList<Drink>();
	

	@GetMapping("getAll")
	public List<Drink> getAll() {
		return drinks;
	}

	@GetMapping("getOne")
	public ResponseEntity<Drink> getOne(int i) {
		// if out of drinks index range
		if (i > drinks.size() || i < 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(drinks.get(i));
	}

	@GetMapping("getByName")
	public ResponseEntity<Drink> getByName(String name) {
		for (Drink drink : drinks) {
			if (drink.getName().equalsIgnoreCase(name)) {
				return ResponseEntity.ok(drink);
			}
		}
		return ResponseEntity.notFound().build();
	}
	// no checks here
	@PostMapping("add")
	public void add(@RequestBody Drink drink) {
		drinks.add(drink);
	}
	
	@DeleteMapping("delete/{i}")
	public ResponseEntity<String> delete(@PathVariable(value = "i" ) int i) {
		System.out.println(i);
		if (i > drinks.size() || i < 0) {
			return ResponseEntity.notFound().build();
		}
		drinks.remove(i);
		return ResponseEntity.ok().build();
	}
}
