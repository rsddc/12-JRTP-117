package com.rs.us.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.us.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
		
	public User findByEmail(String email);
	
	
	public User findByEmailAndPassword(String email,String password);
}
