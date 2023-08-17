package com.github.lucasdevrj.dao;

import javax.persistence.EntityManager;

public class DesenvolvedorDao {
	
	private EntityManager em;
	
	public DesenvolvedorDao(EntityManager em) {
		this.em = em;
	}
}
