package com.gmdiias.controle.compra;

import java.math.BigDecimal;

public class ResumoDebitosDTO {
	public int qtdCompras;
	public BigDecimal valorTotal;
	
	public int getQtdCompras() {
		return qtdCompras;
	}
	
	public void setQtdCompras(int qtdCompras) {
		this.qtdCompras = qtdCompras;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
