package com.gmdiias.controle.compra;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class EstadoService extends BasicService<Estado, EstadoRepository> {
	
}
