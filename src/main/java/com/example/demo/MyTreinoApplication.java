package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dominio.Aluno;
import com.example.demo.repositorios.AlunoRepositorio;

@SpringBootApplication
public class MyTreinoApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(MyTreinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno al = new Aluno(null, "Josias Henrique", "Masculino", 22, 1.73, 87.0);
		Aluno al2 = new Aluno(null, "Maria Helena", "Feminino", 33, 1.68, 110.0);
		Aluno al3 = new Aluno(null, "Julia Marilia", "Feminino", 19, 1.60, 56.0);
		
		alunoRepositorio.saveAll(Arrays.asList(al, al2, al3));
		
	}

}
