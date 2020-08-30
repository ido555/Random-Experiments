package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CruiseShips")
public class CruiseShip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private int numOfPools, numOfRooms;
	
	public CruiseShip() { // CTOR for hibernate
	}

	public CruiseShip(String name, int numOfPools, int numOfRooms) {
		this.name = name;
		this.numOfPools = numOfPools;
		this.numOfRooms = numOfRooms;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumOfPools() {
		return numOfPools;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfPools(int numOfPools) {
		this.numOfPools = numOfPools;
	}

	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	
}
