package com.swone.visor.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.swone.visor.api.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Transactional(readOnly = true)
	Cliente findById(Long id);
	
	@Transactional(readOnly = true)
	Cliente findByNome(String nome);

}
