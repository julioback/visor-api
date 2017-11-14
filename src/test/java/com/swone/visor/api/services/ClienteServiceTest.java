package com.swone.visor.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.swone.visor.api.entities.Cliente;
import com.swone.visor.api.repositories.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {
	
	@MockBean
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	private static final String nome = "Cliente Teste";
	
	@Before
	public void setUp() {
		BDDMockito.given(this.clienteRepository.findByNome(Mockito.anyString())).willReturn(new Cliente());
		BDDMockito.given(this.clienteRepository.save(Mockito.any(Cliente.class))).willReturn(new Cliente());
	}
	
	@Test
	public void testBuscarClientePorNome() {
		Optional<Cliente> cliente = this.clienteService.buscarPorNome(nome);
		
		assertTrue(cliente.isPresent());
	}
	
	@Test
	public void testPersistirCliente() {
		Cliente cliente = this.clienteService.persistir(new Cliente());
		
		assertNotNull(cliente);
	}
}
