package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Player;
import com.example.demo.repos.GameRepo;
import com.example.demo.repos.PlayerRepo;


@Service
@Scope("singleton")
public class Team {
	@Autowired
	GameRepo gRepo;
	@Autowired
	PlayerRepo pRepo;

	public void addPlayer(Player player) {
		pRepo.save(player);
	}
	
	public Player getPlayerById(long id) throws NoSuchElementException {
		return pRepo.findById(id).orElseThrow(NoSuchElementException::new); 
	}
	
	public List<Player> getAllPlayersByName(String name){
		return pRepo.findByName(name);
	}
	
	public List<Player> getAllPlayers() {
		return pRepo.findAll();
	}
	
}
