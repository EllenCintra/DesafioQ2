package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Telefone;

public class TelefoneDto {

	private String numero;
	
	public TelefoneDto(Telefone tel) {
		this.numero = tel.getNumero();
	}
	public TelefoneDto() {
		
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String name) {
		this.numero = name;
	}
}
