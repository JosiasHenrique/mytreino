package com.example.demo.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;

import com.example.demo.servico.excecao.ObjectNotFoundException;

@Service
public class AlunoServico {

	@Autowired
	private AlunoRepositorio repo;
	
	public Aluno buscar(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
}
