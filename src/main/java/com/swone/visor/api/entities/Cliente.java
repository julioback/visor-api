package com.swone.visor.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name= "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String apelido;
	private Boolean ativo;
	private LocalDateTime dataCriacao;
	
	public Cliente() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name= "nome", nullable=false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name= "apelido", nullable=false)
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name= "ativo", nullable=false)
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name= "dtCriacao", nullable=false)
	public LocalDateTime getdataCriacao() {
		return dataCriacao;
	}

	public void setdataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@PrePersist
	public void prePersist() {
		final LocalDateTime atual = LocalDateTime.now();
		dataCriacao = atual;
	}
	
}
