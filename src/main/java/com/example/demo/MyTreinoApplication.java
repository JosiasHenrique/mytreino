package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Exercicio;
import com.example.demo.entities.Ficha;
import com.example.demo.entities.GrupoMuscular;
import com.example.demo.entities.MontagemTreino;
import com.example.demo.entities.Professor;
import com.example.demo.entities.Usuario;
import com.example.demo.entities.enums.DivisaoTreino;
import com.example.demo.entities.enums.Perfil;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.ExercicioRepository;
import com.example.demo.repositories.FichaRepository;
import com.example.demo.repositories.GrupoMuscularRepository;
import com.example.demo.repositories.MontagemTreinoRepository;
import com.example.demo.repositories.ProfessorRepository;
import com.example.demo.repositories.UsuarioRepository;

@SpringBootApplication
public class MyTreinoApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired AlunoRepository alunoRepository;
	
	@Autowired
	private GrupoMuscularRepository grupoMuscularRepository;
	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	@Autowired
	private FichaRepository fichaRepository;
	
	@Autowired
	private MontagemTreinoRepository montagemTreinoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyTreinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario user = new Usuario(null, "josias@gmail.com", pe.encode("123"));
		Usuario user1 = new Usuario(null, "lucas@gmail.com", pe.encode("123"));
		
		user.addPerfil(Perfil.ALUNO);
		user1.addPerfil(Perfil.PROFESSOR);
		
		Professor prof = new Professor(null, "Lucas Augusto", "Masculino", 23, user1);
		Aluno aluno = new Aluno(null, "Josias Henrique", "Masculino", 22, 1.70, 90.0, user);

		
		userRepository.saveAll(Arrays.asList(user, user1));
		professorRepository.saveAll(Arrays.asList(prof));
		

		GrupoMuscular gm = new GrupoMuscular(null, "Peito");
		GrupoMuscular gm1 = new GrupoMuscular(null, "Costas");
		GrupoMuscular gm2 = new GrupoMuscular(null, "Perna");
		GrupoMuscular gm3 = new GrupoMuscular(null, "Glúteo");
		GrupoMuscular gm4 = new GrupoMuscular(null, "Ombro");
		GrupoMuscular gm5 = new GrupoMuscular(null, "Bíceps");
		GrupoMuscular gm6 = new GrupoMuscular(null, "Tríceps");
		GrupoMuscular gm7 = new GrupoMuscular(null, "Outros");

		grupoMuscularRepository.saveAll(Arrays.asList(gm, gm1, gm2, gm3, gm4, gm5, gm6, gm7));

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

		exercicioRepository.saveAll(Arrays.asList(ex, ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9, ex10, ex11));
		Ficha fc = new Ficha(null, aluno);
		aluno.setFicha(fc);
		alunoRepository.saveAll(Arrays.asList(aluno));
		fichaRepository.saveAll(Arrays.asList(fc));
	
		
		MontagemTreino mt = new MontagemTreino(fc, ex, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt1 = new MontagemTreino(fc, ex1, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt2 = new MontagemTreino(fc, ex2, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt3 = new MontagemTreino(fc, ex3, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt4 = new MontagemTreino(fc, ex4, "3", "12", null, DivisaoTreino.A);
		MontagemTreino mt5 = new MontagemTreino(fc, ex9, "3", "12", null, DivisaoTreino.B);
		
		fc.getMontagens().addAll(Arrays.asList(mt, mt1, mt2, mt3, mt4, mt5));
		montagemTreinoRepository.saveAll(Arrays.asList(mt, mt1, mt2, mt3, mt4, mt5));
	}
}