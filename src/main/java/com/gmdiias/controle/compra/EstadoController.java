package com.gmdiias.controle.compra;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/estado")
public class EstadoController extends BasicController<Estado, EstadoRepository, EstadoService>{
	
}
