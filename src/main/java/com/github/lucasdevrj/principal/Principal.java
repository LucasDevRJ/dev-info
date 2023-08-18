package com.github.lucasdevrj.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.CargoDao;
import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Cargo;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.util.JPAUtil;

public class Principal {
	
	private static Scanner entrada = new Scanner(System.in);
	private static EntityManager em = JPAUtil.getEntityManager();
	
	public static void main(String[] args) {
		exibirMenu();
	}

	private static void exibirMenu() {
		System.out.println("1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.println("3 - Excluir Desenvolvedor");
		System.out.println("4 - Atualizar Desenvolvedor");
		System.out.println("5 - Sair");
		
		System.out.print("Digite sua opção: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarDesenvolvedor();
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
				System.out.println("Programa finalizado.");
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
		
		System.out.print("Digite as tecnologias que domina: ");
		desenvolvedor.setTecnologias(entrada.nextLine());
		
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

	private static void cadastrarDesenvolvedor() {
		entrada.nextLine();
		
		System.out.print("Digite o seu nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a sua área: ");
		String area = entrada.nextLine();
		
		System.out.print("Digite as tecnologias que domina: ");
		String tecnologias = entrada.nextLine();
		
		System.out.print("Digite a sua graduação: ");
		String graduacao = entrada.nextLine();
	
		System.out.print("Digite o seu cargo: ");
		String nomeCargo = entrada.nextLine();
		
		Cargo cargo = new Cargo(nomeCargo);
		CargoDao cargoDao = new CargoDao(em);
		cargoDao.cadastrar(cargo);
		
		Desenvolvedor desenvolvedor = new Desenvolvedor(nome, area, tecnologias, graduacao, cargo);
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		desenvolvedorDao.cadastrar(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
        
        System.out.println("Desenvolvedor cadastrado com sucesso!");
        exibirMenu();
	}
}
