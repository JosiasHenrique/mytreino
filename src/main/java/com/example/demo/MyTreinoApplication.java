package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dominio.Aluno;
import com.example.demo.dominio.Exercicio;
import com.example.demo.dominio.Ficha;
import com.example.demo.dominio.GrupoMuscular;
import com.example.demo.dominio.MontagemTreino;
import com.example.demo.dominio.Professor;
import com.example.demo.dominio.enums.DivisaoTreino;
import com.example.demo.repositorios.AlunoRepositorio;
import com.example.demo.repositorios.ExercicioRepositorio;
import com.example.demo.repositorios.FichaRepositorio;
import com.example.demo.repositorios.GrupoMuscularRepositorio;
import com.example.demo.repositorios.MontagemTreinoRepositorio;
import com.example.demo.repositorios.ProfessorRepositorio;

@SpringBootApplication
public class MyTreinoApplication implements CommandLineRunner {

	@Autowired
	private ProfessorRepositorio professorRepositorio;

	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@Autowired
	private GrupoMuscularRepositorio grupoMuscularRepositorio;

	@Autowired
	private ExercicioRepositorio exercicioRepositorio;

	@Autowired
	private FichaRepositorio fichaRepositorio;

	@Autowired
	private MontagemTreinoRepositorio montagemTreinoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(MyTreinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Professor prof = new Professor(null, "Lucas Gado", "Masculino", 21, 1045.0);

		professorRepositorio.saveAll(Arrays.asList(prof));

		Aluno al = new Aluno(null, "Josias Henrique", "Masculino", 22, 1.73, 87.0);
		Aluno al2 = new Aluno(null, "Maria Helena", "Feminino", 33, 1.68, 110.0);
		Aluno al3 = new Aluno(null, "Julia Marilia", "Feminino", 19, 1.60, 56.0);

		alunoRepositorio.saveAll(Arrays.asList(al, al2, al3));

		GrupoMuscular gm = new GrupoMuscular(null, "Peito");
		GrupoMuscular gm1 = new GrupoMuscular(null, "Costas");
		GrupoMuscular gm2 = new GrupoMuscular(null, "Perna");
		GrupoMuscular gm3 = new GrupoMuscular(null, "Glúteo");
		GrupoMuscular gm4 = new GrupoMuscular(null, "Ombro");
		GrupoMuscular gm5 = new GrupoMuscular(null, "Bíceps");
		GrupoMuscular gm6 = new GrupoMuscular(null, "Tríceps");
		GrupoMuscular gm7 = new GrupoMuscular(null, "Outros");

		grupoMuscularRepositorio.saveAll(Arrays.asList(gm, gm1, gm2, gm3, gm4, gm5, gm6, gm7));

		Exercicio ex = new Exercicio(null, "Supino Reto", gm);
		Exercicio ex1 = new Exercicio(null, "Supino Inclinado", gm);
		Exercicio ex2 = new Exercicio(null, "Supino Declinado", gm);
		Exercicio ex3 = new Exercicio(null, "Crucifixo", gm);
		Exercicio ex4 = new Exercicio(null, "Voador", gm);
		Exercicio ex5 = new Exercicio(null, "Cross-over", gm);

		Exercicio ex6 = new Exercicio(null, "Puxador", gm1);
		Exercicio ex7 = new Exercicio(null, "Remada Baixa", gm1);
		Exercicio ex8 = new Exercicio(null, "Remada Cavalinho", gm1);
		Exercicio ex9 = new Exercicio(null, "Fly Invertido", gm1);
		Exercicio ex10 = new Exercicio(null, "Crucifixo Invertido", gm1);
		Exercicio ex11 = new Exercicio(null, "Remada Curvada", gm1);

		gm.getExercicios().addAll(Arrays.asList(ex, ex1, ex2, ex3, ex4, ex5));
		gm1.getExercicios().addAll(Arrays.asList(ex6, ex7, ex8, ex9, ex10, ex11));

		exercicioRepositorio.saveAll(Arrays.asList(ex, ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, ex10, ex11));

		Ficha fc = new Ficha(null, al, prof);

		fichaRepositorio.saveAll(Arrays.asList(fc));

		al.setFicha(fc);

		MontagemTreino mt = new MontagemTreino(fc, ex, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt1 = new MontagemTreino(fc, ex1, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt2 = new MontagemTreino(fc, ex2, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt3 = new MontagemTreino(fc, ex3, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt4 = new MontagemTreino(fc, ex4, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt5 = new MontagemTreino(fc, ex9, "3", "12", null, DivisaoTreino.B);

		if (mt.getCarga() == null) {
			mt.setCarga("Não informado");
		}
		if (mt.getObs() == null) {
			mt.setObs("Não informado");
		}

		fc.getMontagens().addAll(Arrays.asList(mt, mt1, mt2, mt3, mt4, mt5));
		montagemTreinoRepositorio.saveAll(Arrays.asList(mt, mt1, mt2, mt3, mt4, mt5));

	}

}
