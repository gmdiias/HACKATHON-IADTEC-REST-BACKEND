package com.gmdiias.controle.clientes;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;
import com.gmdiias.controle.compra.Estado;
import com.gmdiias.controle.compra.EstadoService;

@Service
@Transactional
public class ClienteService extends BasicService<Cliente, ClienteRepository> {

	@Autowired
	EstadoService estadoService;
	
	public Cliente save(Cliente entity) {
		
		Optional<Estado> opPais = estadoService.findOne(entity.getEstado().getId());
		
		if(opPais.isPresent()) {
			entity.setEstado(opPais.get());
		}
		
        return repository.save(entity);
    }
	
}
