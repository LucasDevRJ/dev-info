package com.github.lucasdevrj.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.CargoDao;
import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.dao.TecnologiaDao;
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
		System.out.println("1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.println("3 - Excluir Desenvolvedor");
		System.out.println("4 - Atualizar Desenvolvedor");
		System.out.println("5 - Listar Tecnologias");
		System.out.println("6 - Listar Cargos");
		
		System.out.print("Digite sua opção: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				CadastroDesenvolvedor cadastroDesenvolvedor = new CadastroDesenvolvedor();
				cadastroDesenvolvedor.cadastrar();
			break;
			
			case 2:
				listarDesenvolvedores();
			break;
			
			case 3:
				excluirDesenvolvedor();
			break;
			
			case 4:
				atualizarDesenvolvedor();
			break;
			
			case 5:
				listarTecnologias();
			break;
			
			case 6:
				listarCargos();
			break;
		}
	}

	private static void atualizarDesenvolvedor() {
		System.out.print("Digite a id do desenvolvedor: ");
		int id = entrada.nextInt();
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		Desenvolvedor desenvolvedor = desenvolvedorDao.buscarPorId(id);
		
		CargoDao cargoDao = new CargoDao(em);
		Cargo cargo = cargoDao.buscarPorId(id);
		
		entrada.nextLine();
		
		System.out.print("Digite o seu nome: ");
		desenvolvedor.setNome(entrada.nextLine());
		
		System.out.print("Digite a sua área: ");
		desenvolvedor.setArea(entrada.nextLine());
		
		List<Tecnologia> tecnologias = new ArrayList<>();
		int opcao = 0;
		do {
			System.out.print("Digite uma tecnologia que domina: ");
			String nome = entrada.nextLine();
			
			Tecnologia tecnologia = new Tecnologia(nome);
			tecnologias.add(tecnologia);
			
			TecnologiaDao tecnologiaDao = new TecnologiaDao(em);
			tecnologiaDao.cadastrar(tecnologia);
			
			System.out.print("Deseja cadastrar outra tecnologia?\n1 - Sim\n2 - Não");
			opcao = entrada.nextInt();
		} while (opcao != 2);
	
		desenvolvedor.setTecnologias(tecnologias);
		
		System.out.print("Digite a sua graduação: ");
		desenvolvedor.setGraduacao(entrada.nextLine());
	
		System.out.print("Digite o seu cargo: ");
		cargo.setNome(entrada.nextLine());
		
		cargoDao.atualizar(cargo);
		desenvolvedorDao.atualizar(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
        
        System.out.println("Desenvolvedor atualizado com sucesso!");
        exibirMenu();
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

	private static void listarDesenvolvedores() {
		em.getTransaction().begin();
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<Desenvolvedor> desenvolvedores = desenvolvedorDao.listar();
		desenvolvedores.forEach(d -> System.out.println(d));
		exibirMenu();
	}
	
	private static void listarTecnologias() {
		em.getTransaction().begin();
		TecnologiaDao tecnologiaDao = new TecnologiaDao(em);
		
		List<Tecnologia> tecnologias = tecnologiaDao.listar();
		tecnologias.forEach(t -> System.out.print(t + " | "));
		System.out.println();
		exibirMenu();
	}
	
	
	private static void listarCargos() {
		em.getTransaction().begin();
		CargoDao cargoDao = new CargoDao(em);
		
		List<Cargo> cargos = cargoDao.listar();
		cargos.forEach(c -> System.out.print(c + " | "));
		System.out.println();
		exibirMenu();
	}
}
