package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Transactional(readOnly=true)
	User findByEmail(String email);
}
