package com.example.demo.resources.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ficha;
import com.example.demo.services.FichaService;

@RestController
@RequestMapping(value = "/fichas")
public class FichaResource {
	
	@Autowired
	private FichaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Ficha> find(@PathVariable Integer id) {
		Ficha obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Ficha> find() {
		Ficha obj = service.find();
		return ResponseEntity.ok().body(obj);
	}*/
}
