package com.swone.visor.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swone.visor.api.entities.Cliente;
import com.swone.visor.api.response.Response;
import com.swone.visor.api.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteController() {
		
	}
	
	/**
	 * Retorna um cliente a partir de um nome
	 * 
	 * @author JulioCésarBack
	 * @param nome
	 * @return
	 */
	@RequestMapping("/nome/{nome}")
	public ResponseEntity<Response<Cliente>> buscarPorNome(@PathVariable("nome") String nome){
		log.info("Buscando o cliente pelo nome: {}", nome);
		Response<Cliente> response = new Response<Cliente>();
		Optional<Cliente> cliente = clienteService.buscarPorNome(nome);
		
		if(!cliente.isPresent()) {
			log.info("Cliente {} não existe", nome);
			response.getErrors().add("Cliente não encontrado com o nome " + nome);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(cliente.get());
		return ResponseEntity.ok(response);
	}
}
