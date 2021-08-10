package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dominio.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Integer> {

}
