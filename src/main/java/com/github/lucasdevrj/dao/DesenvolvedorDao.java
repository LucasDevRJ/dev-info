package com.github.lucasdevrj.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.modelos.Desenvolvedor;

public class DesenvolvedorDao {
	
	private EntityManager em;
	
	public DesenvolvedorDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Desenvolvedor desenvolvedor) {
		this.em.persist(desenvolvedor);
	}
	
	public List<Desenvolvedor> listar() {
		String jpql = "SELECT d FROM Desenvolvedor d";
		return this.em.createQuery(jpql, Desenvolvedor.class).getResultList();
	}
}
