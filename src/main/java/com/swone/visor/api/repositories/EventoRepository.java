package com.swone.visor.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.swone.visor.api.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	
	@Transactional(readOnly = true)
	Evento findById(int id);
	
	@Transactional(readOnly = true)
	List<Evento> findByIdServidor(int idServidor);
	
	@Transactional(readOnly = true)
	List<Evento> findByChave(String chave);

}
