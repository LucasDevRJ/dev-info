package com.github.lucasdevrj.dao;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.modelos.Cargo;
import com.github.lucasdevrj.modelos.Desenvolvedor;

public class CargoDao {

private EntityManager em;
	
	public CargoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cargo cargo) {
		this.em.persist(cargo);
	}
	
	public void atualizar(Cargo cargo) {
		this.em.merge(cargo);
	}
	
	public Cargo buscarPorId(Integer id) {
		return this.em.find(Cargo.class, id);
	}
}