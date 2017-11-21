package com.swone.visor.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swone.visor.api.dto.EventoDto;
import com.swone.visor.api.entities.Evento;
import com.swone.visor.api.response.Response;
import com.swone.visor.api.services.EventoService;
import com.swone.visor.api.services.ServidorService;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin("*")
public class EventoController {

	private static final Logger log = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private ServidorService servidorService;
	
	public EventoController() {
	}
	
	@PostMapping
	public ResponseEntity<Response<EventoDto>> adicionar(@Valid @RequestBody EventoDto eventoDto,
			BindingResult result) {
		log.info("Adicionando lançamento: {}", eventoDto.toString());
		Response<EventoDto> response = new Response<EventoDto>();
		Evento evento = this.converterDtoParaEvento(eventoDto, result);

		evento = this.eventoService.persistir(evento);
		if (result.hasErrors()) {
			log.error("Erro validando lançamento: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(this.convertereventoDto(evento));
		return ResponseEntity.ok(response);
	}

	private EventoDto convertereventoDto(Evento evento) {
		EventoDto eventoDto = new EventoDto();
		eventoDto.setChave(evento.getChave());
		eventoDto.setMensagem(evento.getMensagem());
		eventoDto.setSeveridade(evento.getSeveridade());
		eventoDto.setValor(evento.getValor());
		return eventoDto;
	}

	private Evento converterDtoParaEvento(EventoDto eventoDto, BindingResult result) {
		Evento evento = new Evento();
		evento.setIdServidor(this.servidorService.buscarPorNome(eventoDto.getHostServidor()).get().getId().intValue());
		evento.setChave(eventoDto.getChave());
		evento.setMensagem(eventoDto.getMensagem());
		evento.setSeveridade(eventoDto.getSeveridade());
		evento.setValor(eventoDto.getValor());
		return evento;
	}
	
	
}
