package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dominio.Exercicio;

public interface ExercicioRepositorio extends JpaRepository<Exercicio, Integer> {

}
