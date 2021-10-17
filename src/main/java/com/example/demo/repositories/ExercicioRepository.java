package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {

}
