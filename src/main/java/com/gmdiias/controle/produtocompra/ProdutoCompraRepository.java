package com.gmdiias.controle.produtocompra;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface ProdutoCompraRepository extends BasicRepository<ProdutoCompra> {

}