package com.swone.visor.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.swone.visor.api.entities.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private static final String nome = "Cliente de testes";
	
	@Before
	public void setUp() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setAtivo(true);
		cliente.setApelido(nome);
		this.clienteRepository.save(cliente);
	}
	
	@After
	public final void tearDown() {
		this.clienteRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		Cliente cliente = this.clienteRepository.findByNome(nome);
		
		assertEquals(nome, cliente.getNome());
	}
}
