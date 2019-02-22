package com.gmdiias.controle.produtocompra;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.gmdiias.basic.BasicEntity;
import com.gmdiias.controle.produtos.Produto;

@Entity
public class ProdutoCompra extends BasicEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	private int quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public void mergeEntity(Object received) {
		ProdutoCompra entity = (ProdutoCompra) received;
		this.produto = entity.produto;
		this.quantidade = entity.quantidade;
	}
}
