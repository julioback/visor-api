package com.swone.visor.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.swone.visor.api.enun.TipoEnun;

@Entity
@Table(name= "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String apelido;
	private String email;
	private String senha;
	private int atualizacaoTela;
	private TipoEnun perfil;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	private Cliente cliente;
	
	public Usuario() {
	
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

	@Column(name= "email", nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name= "senha", nullable=false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name= "atualizacaoTela", nullable=false)
	public int getAtualizacaoTela() {
		return atualizacaoTela;
	}

	public void setAtualizacaoTela(int atualizacaoTela) {
		this.atualizacaoTela = atualizacaoTela;
	}

	@Enumerated(EnumType.STRING)
	@Column(name= "perfil", nullable=false)
	public TipoEnun getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoEnun perfil) {
		this.perfil = perfil;
	}

	@Column(name= "dtCriacao", nullable=false)
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name= "dtAtualizacao", nullable=false)
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = LocalDateTime.now();
	}
	
	@PrePersist
	public void prePersist() {
		final LocalDateTime atual = LocalDateTime.now();
		dataAtualizacao = atual;
		dataCriacao = atual;
	}
}
