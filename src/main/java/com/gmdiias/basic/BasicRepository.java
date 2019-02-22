package com.gmdiias.basic;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
 
@Transactional
public interface  BasicRepository <T extends BasicEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}