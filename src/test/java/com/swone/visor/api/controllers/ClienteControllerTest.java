package com.swone.visor.api.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.swone.visor.api.entities.Cliente;
import com.swone.visor.api.services.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {

	@MockBean
	private MockMvc mvc;

	@MockBean
	private ClienteService clienteService;

	private static final String BUSCAR_CLIENTE_NOME_URL = "/api/cliente/nome";
	private static final String NOMECLIENTE = "Empresa para teste";

	@Test
	public void testBuscarClienteNomeInvalido() throws Exception {
		BDDMockito.given(this.clienteService.buscarPorNome(Mockito.anyString())).willReturn(Optional.empty());
		
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_CLIENTE_NOME_URL+ NOMECLIENTE).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.errors").value("Cliente não encontrado com o nome " + NOMECLIENTE));
	}
	
	@Test
	public void testBuscarClienteNomeValido() throws Exception {
		BDDMockito.given(this.clienteService.buscarPorNome(Mockito.anyString())).willReturn(Optional.of(this.obterCliente()));
		
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_CLIENTE_NOME_URL+ NOMECLIENTE).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$data.nome" , equalTo(NOMECLIENTE)))
		.andExpect(jsonPath("$data.errors").isEmpty());
		
	}

	private Cliente obterCliente() {
		Cliente cliente = new Cliente();
		cliente.setApelido("Empresa para teste");
		cliente.setAtivo(true);
		cliente.setNome(NOMECLIENTE);
		cliente.setId(1L);
		return cliente;
	}
}
