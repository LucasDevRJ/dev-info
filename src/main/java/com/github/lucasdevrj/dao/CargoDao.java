package com.github.lucasdevrj.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.lucasdevrj.modelos.Cargo;

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

	public List<Cargo> listar() {
		String jpql = "SELECT c FROM Cargo c";
		return this.em.createQuery(jpql, Cargo.class).getResultList();
	}
}
