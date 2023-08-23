package com.github.lucasdevrj.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.CargoDao;
import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.dao.TecnologiaDao;
import com.github.lucasdevrj.metodos.AtualizarDesenvolvedor;
import com.github.lucasdevrj.metodos.CadastroDesenvolvedor;
import com.github.lucasdevrj.metodos.Listagem;
import com.github.lucasdevrj.modelos.Cargo;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.modelos.Tecnologia;
import com.github.lucasdevrj.util.JPAUtil;

public class Principal {
	
	private static Scanner entrada = new Scanner(System.in);
	private static EntityManager em = JPAUtil.getEntityManager();
	
	public static void main(String[] args) {
		exibirMenu();
	}

	public static void exibirMenu() {
		System.out.println("\n1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.println("3 - Excluir Desenvolvedor");
		System.out.println("4 - Atualizar Desenvolvedor");
		System.out.println("5 - Listar Tecnologias");
		System.out.println("6 - Listar Cargos");
		System.out.println("7 - Listar Graduações");
		System.out.println("8 - Listar Áreas");
		
		System.out.print("Digite sua opção: ");
		int opcao = entrada.nextInt();
		System.out.println();
		Listagem listagem = new Listagem();
		switch (opcao) {
			case 1:
				CadastroDesenvolvedor cadastroDesenvolvedor = new CadastroDesenvolvedor();
				cadastroDesenvolvedor.cadastrar();
			break;
			
			case 2:
				listagem.listarDesenvolvedores();
			break;
			
			case 3:
				excluirDesenvolvedor();
			break;
			
			case 4:
				AtualizarDesenvolvedor atualizarDesenvolvedor = new AtualizarDesenvolvedor();
				atualizarDesenvolvedor.atualizar();
			break;
			
			case 5:
				listarTecnologias();
			break;
			
			case 6:
				listarCargos();
			break;
			
			case 7:
				listarGraduacoes();
			break;
			
			case 8:
				listarAreas();
			break;
		}
	}

	private static void excluirDesenvolvedor() {
		System.out.print("Digite a id do desenvolvedor: ");
		int id = entrada.nextInt();
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		Desenvolvedor desenvolvedor = desenvolvedorDao.buscarPorId(id);
		
		desenvolvedorDao.excluir(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
		
		System.out.println("Desenvolvedor excluído com sucesso!");
		exibirMenu();
	}
	
	private static void listarTecnologias() {
		TecnologiaDao tecnologiaDao = new TecnologiaDao(em);
		
		List<Tecnologia> tecnologias = tecnologiaDao.listar();
		tecnologias.forEach(t -> System.out.print(t + " | "));
		System.out.println();
		exibirMenu();
	}
	
	private static void listarCargos() {
		CargoDao cargoDao = new CargoDao(em);
		
		List<Cargo> cargos = cargoDao.listar();
		cargos.forEach(c -> System.out.print(c + " | "));
		System.out.println();
		exibirMenu();
	}
	
	private static void listarGraduacoes() {
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<String> desenvolvedores = desenvolvedorDao.listarGraduacoes();
		desenvolvedores.forEach(d -> System.out.print(d + " | "));
		System.out.println();
		exibirMenu();
	}
	
	private static void listarAreas() {
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<String> desenvolvedores = desenvolvedorDao.listarAreas();
		desenvolvedores.forEach(d -> System.out.print(d + " | "));
		System.out.println();
		exibirMenu();
	}
}
