package com.gmdiias.controle.clientes;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface ClienteRepository extends BasicRepository<Cliente> {

}