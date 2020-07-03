package com.example.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private long id;
	private String username;
	private String password;
	private String info;
	
	public User() {}

	public User(String username, String password, String info) {
		super();
		this.username = username;
		this.password = password;
		this.info = info;
	}
}
