package com.example.demo.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sexo;
	private Integer idade;
	private Double altura;
	private Double peso;

	public Aluno() {
	}

	public Aluno(Integer id, String nome, String sexo, Integer idade, Double altura, Double peso) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public String getImc() {
		double imc = (peso) / (altura * altura);
		String result = "";
		if (imc < 18.5) {
			result = "Magreza";
		} else if (imc >= 18.5 && imc <= 24.9) {
			result = "Saudável";
		} else if (imc >= 25.0 && imc <= 29.9) {
			result = "Sobrepeso";
		} else if (imc >= 30.0 && imc <= 34.9) {
			result = "Obesidade Grau I";
		} else if (imc >= 35.0 && imc <= 39.9) {
			result = "Obesidade Grau II";
		} else {
			result = "Obesidade Grau III";
		}
		return result;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
