package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dominio.Ficha;

public interface FichaRepositorio extends JpaRepository<Ficha, Integer> {

}
