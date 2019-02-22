package com.gmdiias.controle.compra;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;
import com.gmdiias.controle.pais.Pais;
import com.gmdiias.controle.pais.PaisService;

@Service
@Transactional
public class EstadoService extends BasicService<Estado, EstadoRepository> {
	
	@Autowired
	PaisService paisService;
	
	public Estado save(Estado entity) {
		
		Optional<Pais> opPais = paisService.findOne(entity.getPais().getId());
		
		if(opPais.isPresent()) {
			entity.setPais(opPais.get());
		}
		
        return repository.save(entity);
    }
	
	public List<Estado> findTop5ByNomeLikeOrPaisNomeLike(String nome) {
		nome = "%" + nome + "%";
		return repository.findTop5ByNomeLikeOrPaisNomeLike(nome, nome);
	}
	
}
