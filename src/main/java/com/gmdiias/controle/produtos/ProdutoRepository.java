package com.gmdiias.controle.produtos;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface ProdutoRepository extends BasicRepository<Produto> {

}