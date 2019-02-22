package com.gmdiias.controle.clientes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findRelatorioByFiltros(Optional<String> nome, Optional<Date> data, Optional<String> situacao){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select * from cliente c join estado e on c.estado_id = e.id join pais p on e.pais_id = p.id where ");
		if(nome.isPresent()) {
			sql.append("c.nome ilike '");
			sql.append("%" + nome.get() + "%");
			sql.append("' and ");
		}
		else {
			sql.append("1 = 1 and ");
		}
		if(situacao.isPresent()) {
			sql.append("c.situacao = '");
			sql.append(situacao.get());
			sql.append("' and ");
		}
		else {
			sql.append("1 = 1 and ");
		}
		if(data.isPresent()) {
			sql.append("c.data_nascimento = '");
			sql.append(SIMPLE_DATE_FORMAT.format(data.get()));
			sql.append("'");
		}
		else {
			sql.append("1 = 1");
		}
		
		Query query = em.createNativeQuery(sql.toString(), Cliente.class);
		return query.getResultList(); 
	}
}
