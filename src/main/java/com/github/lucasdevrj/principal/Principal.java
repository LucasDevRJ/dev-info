package com.github.lucasdevrj.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.util.JPAUtil;

public class Principal {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibirMenu();
	}

	private static void exibirMenu() {
		System.out.println("1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.println("3 - Excluir Todos Desenvolvedores");
		
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
		}
	}

	private static void excluirDesenvolvedor() {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.print("Digite a id do desenvolvedor: ");
		int id = entrada.nextInt();
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		Desenvolvedor desenvolvedor = desenvolvedorDao.buscarPorId(id);
		
		desenvolvedorDao.excluir(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
		
		System.out.println("Desenvolvedor excluído com sucesso!");
	}

	private static void listarDesenvolvedores() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		System.out.println("Busca todos os produtos");
		List<Desenvolvedor> desenvolvedores = desenvolvedorDao.listar();
		desenvolvedores.forEach(d -> System.out.println(d));
		System.out.println();
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
		String cargo = entrada.nextLine();
		
		Desenvolvedor desenvolvedor = new Desenvolvedor(nome, area, tecnologias, graduacao, cargo);
		
		EntityManager em = JPAUtil.getEntityManager();
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		desenvolvedorDao.cadastrar(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
        
        System.out.println("Desenvolvedor cadastrado com sucesso!");
	}
}
