package com.gmdiias.controle.clientes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController extends BasicController<Cliente, ClienteRepository, ClienteService>{
}
