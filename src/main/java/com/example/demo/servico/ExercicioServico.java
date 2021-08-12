package com.example.demo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Exercicio;
import com.example.demo.repositorios.ExercicioRepositorio;
import com.example.demo.servico.excecao.ObjectNotFoundException;

@Service
public class ExercicioServico {

	@Autowired
	private ExercicioRepositorio repo;

	public Exercicio buscar(Integer id) {
		Optional<Exercicio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exercicio.class.getName()));
	}

	public Exercicio insert(Exercicio obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);

		repo.deleteById(id);

	}

	public List<Exercicio> findAll() {
		return repo.findAll();
	}

}
