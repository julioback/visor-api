package com.swone.visor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.swone.visor.api.entities.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, String>{
		
	@Transactional(readOnly = true)
	Servidor findByApelido(String nome);

}
