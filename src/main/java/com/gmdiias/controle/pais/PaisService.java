package com.gmdiias.controle.pais;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class PaisService extends BasicService<Pais, PaisRepository> {

	public List<Pais> findTop5ByNomeLike(String nome) {
		nome = "%" + nome + "%";
		return repository.findTop5ByNomeLike(nome);
	}
	
}
