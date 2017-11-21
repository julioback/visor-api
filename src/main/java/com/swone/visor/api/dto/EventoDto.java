package com.swone.visor.api.dto;

public class EventoDto {
	
	private String hostServidor;
	private String chave;
	private String valor;
	private int severidade;
	private String mensagem;
	
	public EventoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHostServidor() {
		return hostServidor;
	}

	public void setHostServidor(String hostServidor) {
		this.hostServidor = hostServidor;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getSeveridade() {
		return severidade;
	}

	public void setSeveridade(int severidade) {
		this.severidade = severidade;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
