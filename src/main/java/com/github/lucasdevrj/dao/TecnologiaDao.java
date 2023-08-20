package com.github.lucasdevrj.dao;

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
}
