package com.example.demo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private int scores;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Game> games;
	
	public Player() {}
	public Player(String name, int scores, List<Game> games) {
		super();
		this.name = name;
		this.scores = scores;
		this.games = games;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public long getId() {
		return id;
	}
}
