package com.gmdiias.controle.pais;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/pais")
public class PaisController extends BasicController<Pais, PaisRepository, PaisService>{
}
