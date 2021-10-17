package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	

}
