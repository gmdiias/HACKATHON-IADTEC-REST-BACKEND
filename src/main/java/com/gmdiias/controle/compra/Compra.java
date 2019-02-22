package com.gmdiias.controle.compra;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.gmdiias.basic.BasicEntity;
import com.gmdiias.controle.clientes.Cliente;
import com.gmdiias.controle.produtocompra.ProdutoCompra;

@Entity
public class Compra extends BasicEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Cliente cliente;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "itens_compra")
    private List<ProdutoCompra> itens;
	private BigDecimal valorCompra;
	private Date data;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ProdutoCompra> getItens() {
		return itens;
	}

	public void setItens(List<ProdutoCompra> itens) {
		this.itens = itens;
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public BigDecimal getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	@Override
	public void mergeEntity(Object received) {
		Compra entity = (Compra) received;
		this.cliente = entity.cliente;
		this.itens = entity.itens;
		this.data = entity.data;
	}
}
