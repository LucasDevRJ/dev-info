package com.github.lucasdevrj.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.util.JPAUtil;

public class Principal {
	
	public static void main(String[] args) {
		cadastrarDesenvolvedor();
		listarDesenvolvedores();
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
		Desenvolvedor desenvolvedor = new Desenvolvedor("Lucas Pereira", "Back-end", "Java, Spring, SQL", "Engenharia de Software", "Estagiário de desenvolvimento Full Stack");
		
		EntityManager em = JPAUtil.getEntityManager();
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		desenvolvedorDao.cadastrar(desenvolvedor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
        em.close();
        
        System.out.println("Desenvolvedor cadastrado com sucesso!");
	}
}
