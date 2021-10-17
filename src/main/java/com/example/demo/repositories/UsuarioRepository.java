package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
