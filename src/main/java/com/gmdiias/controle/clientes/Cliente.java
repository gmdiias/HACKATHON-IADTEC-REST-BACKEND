package com.gmdiias.controle.clientes;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.gmdiias.basic.BasicEntity;

@Entity
public class Cliente extends BasicEntity {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String turma;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public String getNomePai() {
		return nomePai;
	}
	
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public void mergeEntity(Object received) {
		Cliente entity = (Cliente) received;
		this.nome = entity.nome;
		this.turma = entity.turma;
		this.nomePai = entity.nomePai;
		this.nomeMae = entity.nomeMae;
	}
	
}
