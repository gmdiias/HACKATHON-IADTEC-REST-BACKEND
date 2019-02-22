package com.gmdiias.controle.produtos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/produto")
public class ProdutoController extends BasicController<Produto, ProdutoRepository, ProdutoService>{
}
