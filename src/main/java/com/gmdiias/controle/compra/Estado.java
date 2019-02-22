package com.gmdiias.controle.compra;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.gmdiias.basic.BasicEntity;
import com.gmdiias.controle.pais.Pais;

@Entity
public class Estado extends BasicEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String uf;
	@ManyToOne
	@NotNull
    private Pais pais;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public void mergeEntity(Object received) {
		Estado entity = (Estado) received;
		this.nome = entity.nome;
		this.uf = entity.uf;
		this.pais = entity.pais;
	}
	
}
