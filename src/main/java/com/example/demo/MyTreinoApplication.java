package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dominio.Aluno;
import com.example.demo.dominio.Exercicio;
import com.example.demo.dominio.GrupoMuscular;
import com.example.demo.repositorios.AlunoRepositorio;
import com.example.demo.repositorios.ExercicioRepositorio;
import com.example.demo.repositorios.GrupoMuscularRepositorio;

@SpringBootApplication
public class MyTreinoApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	@Autowired
	private GrupoMuscularRepositorio grupoMuscularRepositorio;
	
	@Autowired
	private ExercicioRepositorio exercicioRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(MyTreinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno al = new Aluno(null, "Josias Henrique", "Masculino", 22, 1.73, 87.0);
		Aluno al2 = new Aluno(null, "Maria Helena", "Feminino", 33, 1.68, 110.0);
		Aluno al3 = new Aluno(null, "Julia Marilia", "Feminino", 19, 1.60, 56.0);
		
		GrupoMuscular gm = new GrupoMuscular(null, "Peito");
		GrupoMuscular gm1 = new GrupoMuscular(null, "Costas");
		GrupoMuscular gm2 = new GrupoMuscular(null, "Perna");
		GrupoMuscular gm3 = new GrupoMuscular(null, "Glúteo");
		GrupoMuscular gm4 = new GrupoMuscular(null, "Ombro");
		GrupoMuscular gm5 = new GrupoMuscular(null, "Bíceps");
		GrupoMuscular gm6 = new GrupoMuscular(null, "Tríceps");
		GrupoMuscular gm7 = new GrupoMuscular(null, "Outros");
		
		Exercicio ex = new Exercicio(null, "Supino Reto", gm);
		Exercicio ex1 = new Exercicio(null, "Supino Inclinado", gm);
		Exercicio ex2 = new Exercicio(null, "Supino Declinado", gm);
		Exercicio ex3 = new Exercicio(null, "Crucifixo", gm);
		Exercicio ex4 = new Exercicio(null, "Voador", gm);
		Exercicio ex5 = new Exercicio(null, "Cross-over", gm);
		
		alunoRepositorio.saveAll(Arrays.asList(al, al2, al3));
		grupoMuscularRepositorio.saveAll(Arrays.asList(gm, gm2, gm3, gm4, gm5, gm6, gm7));
		exercicioRepositorio.saveAll(Arrays.asList(ex, ex1, ex2, ex3, ex4, ex5));
	}

}
