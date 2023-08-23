package com.github.lucasdevrj.metodos;

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
import com.github.lucasdevrj.principal.Principal;
import com.github.lucasdevrj.util.JPAUtil;

public class AtualizarDesenvolvedor {

	private static Scanner entrada = new Scanner(System.in);
	private static EntityManager em = JPAUtil.getEntityManager();
	
	public void atualizar() {
		System.out.print("Digite a id do desenvolvedor: ");
		int id = entrada.nextInt();
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		Desenvolvedor desenvolvedor = desenvolvedorDao.buscarPorId(id);
		
		CargoDao cargoDao = new CargoDao(em);
		Cargo cargo = cargoDao.buscarPorId(id);
		
		if (desenvolvedor.equals(null)) {
			throw new NullPointerException("Desenvolvedor não encontrado!");
		} else {
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
	        Principal.exibirMenu();
		}
	}
}
