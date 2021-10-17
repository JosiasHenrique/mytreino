package com.example.demo.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Integer> {

	@Transactional
	Ficha findByAluno(Aluno aluno);
}
