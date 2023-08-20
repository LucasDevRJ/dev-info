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

public class CadastroDesenvolvedor {
	
	private static Scanner entrada = new Scanner(System.in);
	private static EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar() {
		System.out.print("Digite o seu nome: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite a sua área: ");
		String area = entrada.nextLine();
		
		List<Tecnologia> tecnologias = new ArrayList<>();
		int opcao = 0;
		do {
			System.out.print("Digite uma tecnologia que domina: ");
			String nomeTecnologia = entrada.nextLine();
			
			Tecnologia tecnologia = new Tecnologia(nomeTecnologia);
			tecnologias.add(tecnologia);
			
			TecnologiaDao tecnologiaDao = new TecnologiaDao(em);
			tecnologiaDao.cadastrar(tecnologia);
			
			System.out.print("Deseja cadastrar outra tecnologia?\n1 - Sim\n2 - Não");
			opcao = entrada.nextInt();
			
			entrada.nextLine();
		} while (opcao != 2);
	
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
        Principal.exibirMenu();
	}
}
