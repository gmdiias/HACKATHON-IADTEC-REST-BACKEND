package com.gmdiias.controle.clientes;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class ClienteService extends BasicService<Cliente, ClienteRepository> {

}
