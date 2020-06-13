package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);

}
