package com.github.lucasdevrj.metodos;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.principal.Principal;
import com.github.lucasdevrj.util.JPAUtil;

public class Listagem {
	
	private static EntityManager em = JPAUtil.getEntityManager();

	public void listarDesenvolvedores() {
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<Desenvolvedor> desenvolvedores = desenvolvedorDao.listar();
		desenvolvedores.forEach(d -> System.out.println(d));
		Principal.exibirMenu();
	}
}
