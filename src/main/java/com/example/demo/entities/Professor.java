package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sexo;
	private Integer idade;

	@OneToOne
	private Usuario usuario;

	public Professor() {

	}

	public Professor(Integer id, String nome, String sexo, Integer idade, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}