package com.swone.visor.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swone.visor.api.entities.Evento;
import com.swone.visor.api.repositories.EventoRepository;
import com.swone.visor.api.services.EventoService;

@Service
public class EventoServiceImpl implements EventoService{

	private static final Logger logger = LoggerFactory.getLogger(EventoServiceImpl.class);

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Evento persistir(Evento evento) {
		logger.info("Salvando o evento {} no banco de dados", evento.getId());
		return this.eventoRepository.save(evento);
	}

}
