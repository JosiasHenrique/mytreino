package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.entities.enums.DivisaoTreino;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MontagemTreino implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonIgnore
	@EmbeddedId
	private MontagemTreinoPK id = new MontagemTreinoPK();
	
	private String serie;
	private String reps;
	private String carga;
	private String obs;
	private DivisaoTreino divisaoTreino;
	
	public MontagemTreino() {}

	public MontagemTreino(Ficha ficha, Exercicio exercicio, String serie, String reps, String carga, DivisaoTreino divisaoTreino) {
		super();
		id.setFicha(ficha);
		id.setExercicio(exercicio);
		this.serie = serie;
		this.reps = reps;
		this.carga = carga;
		this.divisaoTreino = divisaoTreino;
	}

	@JsonIgnore
	public Ficha getFicha() {
		return id.getFicha();
	}

	public void setFicha(Ficha ficha) {
		id.setFicha(ficha);
	}
	
	public Exercicio getExercicio() {
		return id.getExercicio();
	}

	public void setExercicio(Exercicio ficha) {
		id.setExercicio(ficha);
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public DivisaoTreino getDivisaoTreino() {
		return divisaoTreino;
	}

	public void setDivisaoTreino(DivisaoTreino divisaoTreino) {
		this.divisaoTreino = divisaoTreino;
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
		MontagemTreino other = (MontagemTreino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
