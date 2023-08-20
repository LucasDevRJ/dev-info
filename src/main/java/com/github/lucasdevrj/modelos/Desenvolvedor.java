package com.github.lucasdevrj.modelos;

import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany
	private List<Tecnologia> tecnologias = new ArrayList<>();
	private String graduacao;
	
	@OneToOne
	private Cargo cargo;
	
	public Desenvolvedor(String nome, String area, List<Tecnologia> tecnologias, String graduacao, Cargo cargo) {
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
	
	public void setTecnologias(List<Tecnologia> tecnologias) {
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
