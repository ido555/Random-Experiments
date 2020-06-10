package com.example.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cruiseships")
public class CruiseShip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long id;
	
	@Getter
	@Column(nullable = false)
	private int numOfDecks, numOfPools, numOfRooms;
	
	@ManyToOne
	@Getter @Setter
	private List<Passenger> passengers;

	public CruiseShip(int numOfDecks, int numOfPools, int numOfRooms) {
		this.numOfDecks = numOfDecks;
		this.numOfPools = numOfPools;
		this.numOfRooms = numOfRooms;
	}
}
