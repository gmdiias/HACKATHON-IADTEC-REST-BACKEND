package com.gmdiias.controle.clientes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryCustom {
	
	public List<Cliente> findRelatorioByFiltros(Optional<String> nome, Optional<Date> data, Optional<String> situacao);
}
