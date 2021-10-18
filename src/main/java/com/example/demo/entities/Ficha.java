package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ficha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@JsonIgnore
	@MapsId
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PK_ALUNO")
	private Aluno aluno;

	@OneToMany(mappedBy = "id.ficha", fetch = FetchType.EAGER)
	private Set<MontagemTreino> montagens = new HashSet<>();

	public Ficha() {
	}

	public Ficha(Integer id, Aluno aluno) {
		this.id = id;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Set<MontagemTreino> getMontagens() {
		return montagens;
	}

	public void setMontagens(Set<MontagemTreino> montagensTreino) {
		this.montagens = montagensTreino;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ficha other = (Ficha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}