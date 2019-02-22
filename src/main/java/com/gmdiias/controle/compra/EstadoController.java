package com.gmdiias.controle.compra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmdiias.basic.BasicController;

@RestController
@RequestMapping("api/estado")
public class EstadoController extends BasicController<Estado, EstadoRepository, EstadoService>{
	
	@GetMapping("/autocomplete/{search}")
	public ResponseEntity<List<Estado>> findByCnpjBaseLike(@PathVariable String search) {
		List<Estado> objs = service.findTop5ByNomeLikeOrPaisNomeLike(search);

		if (!objs.isEmpty()) {
			return ResponseEntity.ok().body(objs);
		}
		return ResponseEntity.noContent().build();
	}
}
