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

import com.swone.visor.api.entities.Servidor;
import com.swone.visor.api.repositories.ServidorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServidorServiceTest {
	
	@MockBean
	private ServidorRepository servidorRepository;

	@Autowired
	private ServidorService servidorService;
	
	private static final String nome = "Servidor Teste";
	
	@Before
	public void setUp() {
		BDDMockito.given(this.servidorRepository.findByApelido(Mockito.anyString())).willReturn(new Servidor());
		BDDMockito.given(this.servidorRepository.save(Mockito.any(Servidor.class))).willReturn(new Servidor());
	}
	
	@Test
	public void testBuscarServidorPorNome() {
		Optional<Servidor> servidor = this.servidorService.buscarPorNome(nome);
		
		assertTrue(servidor.isPresent());
	}
	
	@Test
	public void testPersistirServidor() {
		Servidor servidor = this.servidorService.persistir(new Servidor());
		
		assertNotNull(servidor);
	}
}
