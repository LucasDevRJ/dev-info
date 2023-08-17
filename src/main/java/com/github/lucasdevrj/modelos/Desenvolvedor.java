package com.github.lucasdevrj.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desenvolvedores")
public class Desenvolvedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String nome;
	private String area;
	private String tecnologias;
	private String graduacao;
	private String cargo;
	
	public Desenvolvedor(String nome, String area, String tecnologias, String graduacao, String cargo) {
		this.nome = nome;
		this.area = area;
		this.tecnologias = tecnologias;
		this.graduacao = graduacao;
		this.cargo = cargo;
	}
	
	public void setNome(String nome) {
		if (nome.isEmpty()) {
			throw new NullPointerException("Informação vázia!");
		}
		this.nome = nome;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}
	
	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
