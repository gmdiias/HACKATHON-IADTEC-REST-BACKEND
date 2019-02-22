package com.gmdiias.controle.pais;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface PaisRepository extends BasicRepository<Pais> {

}