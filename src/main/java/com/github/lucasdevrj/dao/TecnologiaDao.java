package com.github.lucasdevrj.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.modelos.Tecnologia;

public class TecnologiaDao {

	private EntityManager em;
	
	public TecnologiaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Tecnologia tecnologia) {
		this.em.persist(tecnologia);
	}
	
	public List<Tecnologia> listar() {
		String jpql = "SELECT t FROM Tecnologia t";
		return this.em.createQuery(jpql, Tecnologia.class).getResultList();
	}
}
