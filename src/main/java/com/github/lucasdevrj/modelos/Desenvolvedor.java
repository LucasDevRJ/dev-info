package com.github.lucasdevrj.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne
	private Cargo cargo;
	
	public Desenvolvedor(String nome, String area, String tecnologias, String graduacao, Cargo cargo) {
		this.nome = nome;
		this.area = area;
		this.tecnologias = tecnologias;
		this.graduacao = graduacao;
		this.cargo = cargo;
	}
	
	public Desenvolvedor() {
		
	}
	
	public void setNome(String nome) {
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
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Desenvolvedor [id=" + id + ", nome=" + nome + ", area=" + area + ", tecnologias=" + tecnologias
				+ ", graduacao=" + graduacao + ", cargo=" + cargo.getNome() + "]";
	}
	
	
}
