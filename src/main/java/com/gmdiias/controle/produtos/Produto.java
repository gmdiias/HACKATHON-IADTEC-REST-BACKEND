package com.gmdiias.controle.produtos;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.gmdiias.basic.BasicEntity;

@Entity
public class Produto extends BasicEntity {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	private String descricao;
	private BigDecimal valor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public void mergeEntity(Object received) {
		Produto entity = (Produto) received;
		this.nome = entity.nome;
		this.descricao = entity.descricao;
		this.valor = entity.valor;
	}
}
