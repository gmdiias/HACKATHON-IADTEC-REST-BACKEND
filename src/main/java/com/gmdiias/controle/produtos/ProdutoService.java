package com.gmdiias.controle.produtos;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class ProdutoService extends BasicService<Produto, ProdutoRepository> {

}
