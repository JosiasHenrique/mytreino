package com.example.demo.recurso;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dominio.GrupoMuscular;
import com.example.demo.dto.GrupoMuscularDTO;
import com.example.demo.servico.GrupoMuscularServico;


@RestController
@RequestMapping(value="/gruposmusculares")
public class GrupoMuscularRecurso {

	@Autowired
	private GrupoMuscularServico servico; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<GrupoMuscular> find(@PathVariable Integer id) {
		GrupoMuscular obj = servico.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*O Método chama um serviço reponsavel por inserir o objeto no banco de dados.*/
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody GrupoMuscular obj){
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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GrupoMuscularDTO>> buscarTodos() {
		List<GrupoMuscular> list = servico.buscarTodos();
		/*Converter a lista de grupo musculares para lista de grupo musculares DTO
		 e converter para lista */
		List<GrupoMuscularDTO> listDto = list.stream().map(obj -> new GrupoMuscularDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
