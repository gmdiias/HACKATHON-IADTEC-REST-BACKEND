package com.gmdiias.controle.clientes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteTest {
	
	@Autowired
	ClienteService clienteService;
	
	@Test
	public void ClienteCadastroTest() {
		Cliente cliente = new Cliente();
		cliente.setNome("Carolina B�rbara Daiane Gomes");
//		cliente.setNomeMae("Milena Regina");
//		cliente.setNomePai("Renato Lu�s Anthony Gomes");
//		cliente.setTurma("Turma 1");
		
		Cliente saved = clienteService.save(cliente);
		
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertNotNull(saved.getDataCriacao());
		assertEquals(cliente.getNome(), saved.getNome());
	}
	
}
