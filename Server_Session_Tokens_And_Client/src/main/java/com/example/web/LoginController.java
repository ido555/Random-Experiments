package com.example.web;

import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.User;
import com.example.db.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private UserRepository repo;	
	private Map<String, User> sessions;

	
	public LoginController(UserRepository repo, Map<String, User> sessions) {
		this.repo = repo;
		this.sessions = sessions;
	}


	@PostMapping("login/{username}/{password}")
	public ResponseEntity<String> login(@PathVariable String username,@PathVariable String password){
		// find if username and password found in DB
		User user = repo.findByUsernameAndPassword(username, password);
		if(user!=null) {
			// create token! (universal unique id)
			String token = UUID.randomUUID().toString();
			// save user with token as the key in sessions Map
			sessions.put(token, user);
			// return the token to the client
			return ResponseEntity.ok(token);
		} else 
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login");
	}
	
	@PostMapping("logout/{token}")
	public ResponseEntity<String> logout(@PathVariable String token) {
		sessions.remove(token);
		return ResponseEntity.ok("logged out");
	}
}
