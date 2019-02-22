package com.gmdiias.basic;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
 
@Transactional
public class BasicService<T extends BasicEntity, R extends BasicRepository<T>> {
    
    @Autowired
    protected R repository;
    
    public Optional<T> findOne(Long id) {
        return repository.findById(id);
    }
 
    public List<T> findAll() {
        return repository.findAll();
    }
    
    public Page<T> findAll(Specification<T> spec, Pageable pageable){
        return repository.findAll(spec, pageable);
    }
    
    public Page<T> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }
 
    public T save(T entity) {
        return repository.save(entity);
    }
    
    public List<T> saveAll(Iterable<T> entities) {
        return repository.saveAll(entities);
    }
    
    public void delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);            
        }        
    }
    
    public long countAll() {
    	return repository.count();
    }
}