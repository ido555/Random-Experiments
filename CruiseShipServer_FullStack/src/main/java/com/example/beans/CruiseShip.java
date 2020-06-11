package com.example.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cruiseships")
@Getter @Setter
public class CruiseShip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private long id;
	
	@Column(nullable = false)
	@Setter(value = AccessLevel.NONE)
	private String name;
	
	@Column(nullable = false)
	@Setter(value = AccessLevel.NONE)
	private int numOfDecks, numOfPools, numOfRooms;
	
	@ManyToOne
	private List<Passenger> passengers;

	public CruiseShip(int numOfDecks, int numOfPools, int numOfRooms, String name) {
		this.name = name;
		this.numOfDecks = numOfDecks;
		this.numOfPools = numOfPools;
		this.numOfRooms = numOfRooms;
	}
}
