package com.gmdiias.controle.compra;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/compra")
public class CompraController extends BasicController<Compra, CompraRepository, CompraService>{
	
	@GetMapping("resumo/{id}")
	public ResponseEntity<ResumoDebitosDTO> findResumoByIdCliente(@PathVariable Long id) {
		ResumoDebitosDTO resumo = service.obtemResumoDebito(id);

		return ResponseEntity.ok().body(resumo);
	}
}
