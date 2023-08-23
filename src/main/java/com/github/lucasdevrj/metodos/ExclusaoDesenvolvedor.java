package com.github.lucasdevrj.metodos;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.principal.Principal;
import com.github.lucasdevrj.util.JPAUtil;

public class ExclusaoDesenvolvedor {
	
	private static Scanner entrada = new Scanner(System.in);
	private static EntityManager em = JPAUtil.getEntityManager();

	public void excluir() {
		System.out.print("Digite a id do desenvolvedor: ");
		int id = entrada.nextInt();
		
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		Desenvolvedor desenvolvedor = desenvolvedorDao.buscarPorId(id);
		
		if (desenvolvedor.equals(null)) {
			throw new NullPointerException("Desenvolvedor não encontrado!");
		} else {
			desenvolvedorDao.excluir(desenvolvedor);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
	        em.close();
			
			System.out.println("Desenvolvedor excluído com sucesso!");
			Principal.exibirMenu();
		}
	}
}
