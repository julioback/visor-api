package com.swone.visor.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swone.visor.api.entities.Servidor;
import com.swone.visor.api.repositories.ServidorRepository;
import com.swone.visor.api.services.ServidorService;

@Service
public class ServidorServiceImpl implements ServidorService{

	private static final Logger logger = LoggerFactory.getLogger(ServidorServiceImpl.class);

	@Autowired
	private ServidorRepository servidorRepository;
	
	@Override
	public Optional<Servidor> buscarPorNome(String nome) {
		logger.info("Buscando um servidor pelo nome {}", nome);
		return Optional.ofNullable(servidorRepository.findByApelido(nome));
	}

	@Override
	public Servidor persistir(Servidor servidor) {
		logger.info("Salvando o cliente {} no banco de dados", servidor.getApelido());
		return this.servidorRepository.save(servidor);
	}

}
