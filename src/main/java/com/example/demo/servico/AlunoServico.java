package com.example.demo.servico;

import java.util.List;
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

	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);

		repo.deleteById(id);

	}

	public List<Aluno> findAll() {
		return repo.findAll();
	}

}
