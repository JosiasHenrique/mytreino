package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dominio.Professor;

public interface ProfessorRepositorio extends JpaRepository<Professor, Integer> {

}
