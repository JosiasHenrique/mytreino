package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entities.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String email;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		email = entity.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}