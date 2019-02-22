package com.gmdiias.controle.compra;

import java.util.List;

import javax.transaction.Transactional;

import com.gmdiias.basic.BasicRepository;

@Transactional
public interface EstadoRepository extends BasicRepository<Estado> {
	
	List<Estado> findTop5ByNomeLikeOrPaisNomeLike(String nome, String nomePais);
}