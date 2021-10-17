package com.example.demo.entities.enums;

public enum DivisaoTreino {

	A(1, "TREINO_A"),
	B(2, "TREINO_B"),
	C(3, "TREINO_C");
	
	private int cod;
	private String descricao;
	
	private DivisaoTreino(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}