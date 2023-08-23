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
	
	public void excluir(Desenvolvedor desenvolvedor) {
		desenvolvedor = this.em.merge(desenvolvedor);
		this.em.remove(desenvolvedor);
	}
	
	public void atualizar(Desenvolvedor desenvolvedor) {
		this.em.merge(desenvolvedor);
	}
	
	public Desenvolvedor buscarPorId(Integer id) {
		return this.em.find(Desenvolvedor.class, id);
	}
	
	public List<Desenvolvedor> listar() {
		String jpql = "SELECT d FROM Desenvolvedor d";
		return this.em.createQuery(jpql, Desenvolvedor.class).getResultList();
	}
	
	public List<String> listarGraduacoes() {
		String jpql = "SELECT d.graduacao FROM Desenvolvedor d";
		return this.em.createQuery(jpql, String.class).getResultList();
	}
	
	public List<String> listarAreas() {
		String jpql = "SELECT d.area FROM Desenvolvedor d";
		return this.em.createQuery(jpql, String.class).getResultList();
	}
}
