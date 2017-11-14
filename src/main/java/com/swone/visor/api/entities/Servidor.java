package com.swone.visor.api.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "servidor")
public class Servidor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idCliente;
	private String hostname;
	private String apelido;
	private String port;
	private String descricao;
	private Timestamp dataCadastro;
	private Timestamp ultimaAtualizacao;
	private Timestamp ultimoContato;
	
	public Servidor() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="idCliente", nullable=false)
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	@Column(name="hostname", nullable=false)
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	@Column(name="apelido", nullable=false)
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	@Column(name="porta", nullable=true)
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Column(name="descricao", nullable=false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Column(name="dtDatacadastro", nullable=true)
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Column(name="dtUltimaAtualizacao", nullable=true)
	public Timestamp getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	@Column(name="dtUltimoContato", nullable=true)
	public Timestamp getUltimoContato() {
		return ultimoContato;
	}

	public void setUltimoContato(Timestamp ultimoContato) {
		this.ultimoContato = ultimoContato;
	}
	@PreUpdate
	public void preUpdate() {
		ultimaAtualizacao = new Timestamp(System.currentTimeMillis());
	}
	@PrePersist
	public void prePersist() {
		final Timestamp atual = new Timestamp(System.currentTimeMillis());
		ultimaAtualizacao = atual;
		dataCadastro = atual;
	}
	
}
