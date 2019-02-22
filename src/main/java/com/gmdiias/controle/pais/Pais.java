package com.gmdiias.controle.pais;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.gmdiias.basic.BasicEntity;

@Entity
public class Pais extends BasicEntity {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void mergeEntity(Object received) {
		Pais entity = (Pais) received;
		this.nome = entity.nome;
	}
}
