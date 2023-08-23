package com.github.lucasdevrj.metodos;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.dao.CargoDao;
import com.github.lucasdevrj.dao.DesenvolvedorDao;
import com.github.lucasdevrj.dao.TecnologiaDao;
import com.github.lucasdevrj.modelos.Cargo;
import com.github.lucasdevrj.modelos.Desenvolvedor;
import com.github.lucasdevrj.modelos.Tecnologia;
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
	
	public void listarTecnologias() {
		TecnologiaDao tecnologiaDao = new TecnologiaDao(em);
		
		List<Tecnologia> tecnologias = tecnologiaDao.listar();
		tecnologias.forEach(t -> System.out.print(t + " | "));
		System.out.println();
		Principal.exibirMenu();
	}
	
	public void listarCargos() {
		CargoDao cargoDao = new CargoDao(em);
		
		List<Cargo> cargos = cargoDao.listar();
		cargos.forEach(c -> System.out.print(c + " | "));
		System.out.println();
		Principal.exibirMenu();
	}
	
	public void listarGraduacoes() {
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<String> desenvolvedores = desenvolvedorDao.listarGraduacoes();
		desenvolvedores.forEach(d -> System.out.print(d + " | "));
		System.out.println();
		Principal.exibirMenu();
	}
	
	public void listarAreas() {
		DesenvolvedorDao desenvolvedorDao = new DesenvolvedorDao(em);
		
		List<String> desenvolvedores = desenvolvedorDao.listarAreas();
		desenvolvedores.forEach(d -> System.out.print(d + " | "));
		System.out.println();
		Principal.exibirMenu();
	}
}
