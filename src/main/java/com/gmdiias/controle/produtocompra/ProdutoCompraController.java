package com.gmdiias.controle.produtocompra;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/produtocompra")
public class ProdutoCompraController extends BasicController<ProdutoCompra, ProdutoCompraRepository, ProdutoCompraService>{
}
