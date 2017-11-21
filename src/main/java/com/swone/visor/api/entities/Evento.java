package com.swone.visor.api.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int idServidor;
	private String chave;
	private String valor;
	private int severidade;
	private String mensagem;
	private Timestamp dataCriacao;
	
	public Evento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name= "idServidor", nullable=false)
	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

	@Column(name= "chave", nullable=false)
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	@Column(name= "valor", nullable=false)
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name= "severidade", nullable=false)
	public int getSeveridade() {
		return severidade;
	}

	public void setSeveridade(int severidade) {
		this.severidade = severidade;
	}

	@Column(name= "mensagem", nullable=false)
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Column(name= "dtCriacao", nullable=false)
	public Timestamp getdataCriacao() {
		return dataCriacao;
	}

	public void setdataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@PrePersist
	public void prePersist() {
		final Timestamp atual = new Timestamp(System.currentTimeMillis());
		dataCriacao = atual;
	}

}
