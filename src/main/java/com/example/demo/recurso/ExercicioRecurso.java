package com.example.demo.recurso;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dominio.Exercicio;
import com.example.demo.servico.ExercicioServico;


@RestController
@RequestMapping(value="/exercicios")
public class ExercicioRecurso {

	@Autowired
	private ExercicioServico servico; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Exercicio> find(@PathVariable Integer id) {
		Exercicio obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*O Método chama um serviço reponsavel por inserir o objeto no banco de dados.*/
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Exercicio obj){
		obj = servico.insert(obj);
		//retornar a uri do novo obj inserido com o fromCurrentRequest() e converter o id para uri.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
