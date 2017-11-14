package com.swone.visor.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swone.visor.api.entities.Servidor;
import com.swone.visor.api.response.Response;
import com.swone.visor.api.services.ServidorService;

@RestController
@RequestMapping("api/cadastrar-servidor")
@CrossOrigin(origins = "*")
public class ServidorController {

	private static Logger log = LoggerFactory.getLogger(ServidorController.class);
	
	@Autowired
	private ServidorService servidorService;

	public ServidorController() {
		
	}
	
	@PostMapping
	public ResponseEntity<Response<Servidor>> cadastrar(@RequestBody Servidor servidor, BindingResult result){
		log.info("Cadastrando servidor {}", servidor.getApelido());
		
		Response<Servidor> response = new Response<Servidor>();
		
		validarDadosExistentes(servidor, result);
		
		if(result.hasErrors()) {
			log.info("Erro ao validar dados do servidor: {}", servidor.getApelido());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.servidorService.persistir(servidor);
		response.setData(servidor);
		return ResponseEntity.ok(response);
	}

	private void validarDadosExistentes(Servidor servidor, BindingResult result) {
		this.servidorService.buscarPorNome(servidor.getApelido()).ifPresent(serv -> result.addError(new ObjectError("Servidor", "Servidor já existe")));
		
	}
}
