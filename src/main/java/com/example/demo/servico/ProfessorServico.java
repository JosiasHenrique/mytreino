package com.example.demo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Professor;
import com.example.demo.repositorios.ProfessorRepositorio;
import com.example.demo.servico.excecao.ObjectNotFoundException;

@Service
public class ProfessorServico {

	@Autowired
	private ProfessorRepositorio repo;

	public Professor buscar(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}

	public Professor insert(Professor obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);

		repo.deleteById(id);

	}

	public List<Professor> findAll() {
		return repo.findAll();
	}

}
