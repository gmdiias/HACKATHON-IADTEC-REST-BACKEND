package com.gmdiias.controle.compra;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface EstadoRepository extends BasicRepository<Estado> {
}