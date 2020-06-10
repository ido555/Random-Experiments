package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.enums.BookingStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@Getter @Setter
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private int roomNumber;
	
	@Column(nullable = false)
	private BookingStatus status;
	
	@Column(nullable = false)
	@OneToMany
	private CruiseShip ship;

	public Passenger(String name, int roomNumber, BookingStatus status, CruiseShip ship) {
		this.name = name;
		this.roomNumber = roomNumber;
		this.status = status;
		this.ship = ship;
	}
}
