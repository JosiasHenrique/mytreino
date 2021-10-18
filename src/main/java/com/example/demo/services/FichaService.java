package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ficha;
import com.example.demo.repositories.FichaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class FichaService {

	@Autowired
	private FichaRepository repo;
	
	@Autowired
	private AlunoService service;
	
	
	public Ficha find(Integer id) {

		Optional<Ficha> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ficha.class.getName()));
	}

	
	
	/*public Ficha find() {
		
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Aluno aluno = service.find(user.getId());
		Ficha ficha = repo.findByAluno(aluno);
		return ficha;
	}*/
}
