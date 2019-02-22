package com.gmdiias.controle.pais;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gmdiias.basic.BasicService;

@Service
@Transactional
public class PaisService extends BasicService<Pais, PaisRepository> {

}
