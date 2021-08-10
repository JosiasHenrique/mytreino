package com.example.demo.recurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.Aluno;
import com.example.demo.servico.AlunoServico;

@RestController
@RequestMapping(value="/alunos")
public class AlunoRecurso {

	@Autowired
	private AlunoServico servico; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		Aluno obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
