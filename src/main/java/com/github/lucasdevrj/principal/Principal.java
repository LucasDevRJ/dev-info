package com.github.lucasdevrj.principal;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.util.JPAUtil;

public class Principal {
	
	private static Scanner entrada = new Scanner("System.in");
	
	public static void main(String[] args) {
		System.out.println("1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.print("Digite a sua opção desejada: ");
		int opcao = entrada.nextInt();
		
		switch (opcao) {
			case 1:
				cadastrarDesenvolvedor();
			break;
			
			case 2:
				listarDesenvolvedores();
			break;
		}
	}

	private static void listarDesenvolvedores() {
		
	}

	private static void cadastrarDesenvolvedor() {
		System.out.print("Digite seu nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite sua área: ");
		String area = entrada.nextLine();
		
		System.out.print("Digite as tecnologias que domina: ");
		String tecnologias = entrada.nextLine();
		
		System.out.print("Digite a sua graduação: ");
		String graduacao = entrada.nextLine();
		
		System.out.print("Digite o seu cargo: ");
		String cargo = entrada.nextLine();
		
		EntityManager em = JPAUtil.getEntityManager();
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		Desenvolvedor desenvolvedor = new Desenvolvedor(nome, area, tecnologias, graduacao, cargo);
		
		desenvolvedorDao.cadastrar(desenvolvedor);
		
		em.getTransaction().commit();
        em.close();
        
        System.out.println("Desenvolvedor cadastrado com sucesso!");
	}
}
