package com.example.demo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Ficha;
import com.example.demo.repositorios.FichaRepositorio;
import com.example.demo.servico.excecao.ObjectNotFoundException;

@Service
public class FichaServico {

	@Autowired
	private FichaRepositorio repo;

	public Ficha buscar(Integer id) {
		Optional<Ficha> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ficha.class.getName()));
	}

	public Ficha insert(Ficha obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);

		repo.deleteById(id);

	}

	public List<Ficha> findAll() {
		return repo.findAll();
	}

}
