package com.gmdiias.controle.pais;

import java.util.List;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface PaisRepository extends BasicRepository<Pais> {

	List<Pais> findTop5ByNomeLike(String nome);
	
}