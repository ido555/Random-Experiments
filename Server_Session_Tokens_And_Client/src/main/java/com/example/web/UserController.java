package com.example.web;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.User;
import com.example.db.UserRepository;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	// I'm using the Repository and not a Service to make this a simple example
	private UserRepository repo;
	
	private Map<String, User> sessions;

	public UserController(UserRepository repo, Map<String, User> sessions) {
		super();
		this.repo = repo;
		this.sessions = sessions;
	}
	
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		repo.save(user);
		return user;
	}
	
	@GetMapping("{token}")
	public ResponseEntity<String> getInfo(@PathVariable String token) {
		// try to get User from the sessions Map using token sent from client
		User user = sessions.get(token);
		// check if User was found
		if(user!=null)
			// if found return the info...
			return ResponseEntity.ok(user.getInfo());
		else
			// if not found send error!
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized login!");
	}
	
}
