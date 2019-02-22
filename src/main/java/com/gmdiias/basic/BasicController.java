package com.gmdiias.basic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class BasicController<T extends BasicEntity, R extends BasicRepository<T>, S extends BasicService<T, R>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		List<T> objs = service.findAll();

		if (!objs.isEmpty()) {
			return ResponseEntity.ok().body(objs);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = { "search" })
	public ResponseEntity<Page<T>> search(@RequestParam(value = "search") Optional<String> search,
			@Qualifier("page") Pageable pageable) {
		Page<T> page = service.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<T>> findById(@PathVariable Long id) {
		Optional<T> obj = service.findOne(id);

		if (obj.isPresent()) {
			return ResponseEntity.ok().body(obj);
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<T> insert(@RequestBody T obj) {
		T saved = service.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping
	public ResponseEntity<T> update(@RequestBody T recurso) {
		Optional<T> updted = this.service.findOne(recurso.id);

		if (updted.isPresent()) {
			T entity = updted.get();
			entity.mergeEntity(recurso);
			T saved = this.service.save(entity);
			return ResponseEntity.ok().body(saved);
		}

		T saved = this.service.save(recurso);
		return ResponseEntity.ok().body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = { "count" })
	public ResponseEntity<Long> countAll() {
		return ResponseEntity.ok().body(service.countAll());
	}

}