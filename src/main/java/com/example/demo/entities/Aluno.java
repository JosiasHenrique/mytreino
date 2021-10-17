package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ALUNO")
	private Integer id;
	private String nome;
	private String sexo;
	private Integer idade;
	private Double altura;
	private Double peso;

	@JsonIgnore
	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	private Ficha ficha;

	@JsonIgnore
	@OneToOne
	private Usuario usuario;

	public Aluno() {

	}

	public Aluno(Integer id, String nome, String sexo, Integer idade, Double altura, Double peso, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
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

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}