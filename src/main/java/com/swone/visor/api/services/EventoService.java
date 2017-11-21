package com.swone.visor.api.services;

import com.swone.visor.api.entities.Evento;

public interface EventoService {

	/**
	 * Retorna um evento buscando por chave
	 * 
	 * @author JulioCésarBack
	 * @param nome
	 * @return
	 */
	//Optional<Evento> buscarIdServidor(int idServidor);
	
	/**
	 * Cadastra um evento na base de dados
	 * 
	 * @author JulioCésarBack
	 * @param evento
	 * @return
	 */
	Evento persistir(Evento evento);
}
