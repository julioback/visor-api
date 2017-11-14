package com.swone.visor.api.services;

import java.util.Optional;

import com.swone.visor.api.entities.Cliente;

public interface ClienteService {

	/**
	 * Retorna um cliente buscando por um nome
	 * 
	 * @author JulioCésarBack
	 * @param nome
	 * @return
	 */
	Optional<Cliente> buscarPorNome(String nome);
	
	/**
	 * Cadastra um cliente na base de dados
	 * 
	 * @author JulioCésarBack
	 * @param cliente
	 * @return
	 */
	Cliente persistir(Cliente cliente);
}
