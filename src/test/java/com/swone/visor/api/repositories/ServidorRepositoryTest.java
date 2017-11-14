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

import com.swone.visor.api.entities.Servidor;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServidorRepositoryTest {
	
	@Autowired
	private ServidorRepository servidorRepository;
	
	private static final String hostnome = "Servidor de testes";
	
	@Before
	public void setUp() {
		Servidor servidor = new Servidor();
		servidor.setHostname(hostnome);
		servidor.setApelido(hostnome);
		servidor.setDescricao(hostnome);
		servidor.setIdCliente(0L);
		this.servidorRepository.save(servidor);
	}
	
	@After
	public final void tearDown() {
		this.servidorRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		Servidor servidor = this.servidorRepository.findByApelido(hostnome);
		
		assertEquals(hostnome, servidor.getApelido());
	}

}
