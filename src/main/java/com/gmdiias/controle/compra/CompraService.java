package com.gmdiias.controle.compra;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;
import com.gmdiias.controle.clientes.Cliente;
import com.gmdiias.controle.clientes.ClienteService;
import com.gmdiias.controle.produtocompra.ProdutoCompra;
import com.gmdiias.controle.produtocompra.ProdutoCompraService;
import com.gmdiias.controle.produtos.Produto;
import com.gmdiias.controle.produtos.ProdutoService;

@Service
@Transactional
public class CompraService extends BasicService<Compra, CompraRepository> {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProdutoCompraService produtoCompraService;
	
	@Autowired
	ProdutoService produtoService;
	
	public Compra save(Compra entity) {
		
		Optional<Cliente> clienteOp = clienteService.findOne(entity.getCliente().getId());
		
		BigDecimal valorCompra = new BigDecimal(0);
		
		if(clienteOp.isPresent()) {
			entity.setCliente(clienteOp.get());
			
			for(ProdutoCompra produto : entity.getItens()) {
				Optional<Produto> prod = produtoService.findOne(produto.getProduto().getId());
				valorCompra =  valorCompra.add(prod.get().getValor().multiply(new BigDecimal(produto.getQuantidade())));
				produto.setProduto(prod.get());
			}
			
			List<ProdutoCompra> produtos = produtoCompraService.saveAll(entity.getItens());
			entity.setItens(produtos);
		}
		entity.setValorCompra(valorCompra);
        return repository.save(entity);
    }
	
	public ResumoDebitosDTO obtemResumoDebito(Long clienteId) {
		List<Compra> listaCompras = repository.findAllByClienteId(clienteId);
		
		int qtdCompras = 0;
		BigDecimal valorTotal = new BigDecimal(0);
		
		
		for(Compra compra : listaCompras) {
			qtdCompras++;
			if(compra.getValorCompra() != null) {
				valorTotal = valorTotal.add(compra.getValorCompra());				
			}
		}
		
		ResumoDebitosDTO resumo = new ResumoDebitosDTO();
		resumo.setQtdCompras(qtdCompras);
		resumo.setValorTotal(valorTotal);
		return resumo;
	}
	
}
