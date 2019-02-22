package com.gmdiias.controle.pais;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/pais")
public class PaisController extends BasicController<Pais, PaisRepository, PaisService>{
	
	@GetMapping("/autocomplete/{search}")
	public ResponseEntity<List<Pais>> findByCnpjBaseLike(@PathVariable String search) {
		List<Pais> objs = service.findTop5ByNomeLike(search);

		if (!objs.isEmpty()) {
			return ResponseEntity.ok().body(objs);
		}

		return ResponseEntity.noContent().build();
	}
	
}
