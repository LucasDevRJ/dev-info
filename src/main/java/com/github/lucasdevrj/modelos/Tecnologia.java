package com.github.lucasdevrj.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecnologias")
public class Tecnologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	public Tecnologia(String nome) {
		this.nome = nome;
	}
	
	public Tecnologia() {
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
