package com.swone.visor.api.services;

import java.util.Optional;

import com.swone.visor.api.entities.Servidor;

public interface ServidorService {

	/**
	 * Retorna um servidor buscando por um nome
	 * 
	 * @author JulioCésarBack
	 * @param nome
	 * @return
	 */
	Optional<Servidor> buscarPorNome(String nome);
	
	/**
	 * Cadastra um servidor na base de dados
	 * 
	 * @author JulioCésarBack
	 * @param cliente
	 * @return
	 */
	Servidor persistir(Servidor servidor);
}
