package com.gmdiias.controle.compra;

import java.util.List;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface CompraRepository extends BasicRepository<Compra> {
	List<Compra> findAllByClienteId(Long idCliente);
}