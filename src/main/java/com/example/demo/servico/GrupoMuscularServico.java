package com.example.demo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.example.demo.servico.excecao.DataIntegrityException;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.GrupoMuscular;
import com.example.demo.repositorios.GrupoMuscularRepositorio;
import com.example.demo.servico.excecao.ObjectNotFoundException;

@Service
public class GrupoMuscularServico {

	@Autowired
	private GrupoMuscularRepositorio repo;

	public GrupoMuscular buscar(Integer id) {
		Optional<GrupoMuscular> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + GrupoMuscular.class.getName()));
	}

	public GrupoMuscular insert(GrupoMuscular obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);
		/*Try catch para não deixar excluir uma entidade que possui outra entidade relacionada.
		 e capturar isso no recurso.excecoes.ResourceExceptionHandler */
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Agrupamento muscular que possui exercícios.");
		}
	}

	public List<GrupoMuscular> buscarTodos() {
		return repo.findAll();
	}

}
