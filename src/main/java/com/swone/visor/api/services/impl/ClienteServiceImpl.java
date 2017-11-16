package com.swone.visor.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swone.visor.api.entities.Cliente;
import com.swone.visor.api.repositories.ClienteRepository;
import com.swone.visor.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Optional<Cliente> buscarPorNome(String nome) {
		logger.info("Buscando um cliente pelo nome {}", nome);
		return Optional.ofNullable(clienteRepository.findByNome(nome));
	}

	@Override
	public Cliente persistir(Cliente cliente) {
		logger.info("Salvando o cliente {} no banco de dados", cliente.getNome());
		return this.clienteRepository.save(cliente);
	}

}
