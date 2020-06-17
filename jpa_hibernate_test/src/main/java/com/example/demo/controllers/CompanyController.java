package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.beans.Player;
import com.example.demo.services.Team;

@RestController
@RequestMapping("company")
public class CompanyController {
	@Autowired
	Team team;

	@PostMapping("addPlayer")
	public ResponseEntity<?> addPlayer(@RequestBody Player player){
		team.addPlayer(player);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("getOne/{id}")
	public ResponseEntity<?> getOnePlayer(@PathVariable long id) {
		try {
			return ResponseEntity.ok(team.getPlayerById(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("getAllPlayers")
	public List<Player> getAllPlayers(){
		return team.getAllPlayers();
	}
	@GetMapping("getPlayersByName/{name}")
	public List<Player> getPlayersByName(@PathVariable String name){
		return team.getAllPlayersByName(name);
	}
}
