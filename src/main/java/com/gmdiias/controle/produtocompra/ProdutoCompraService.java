package com.gmdiias.controle.produtocompra;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class ProdutoCompraService extends BasicService<ProdutoCompra, ProdutoCompraRepository> {

}
