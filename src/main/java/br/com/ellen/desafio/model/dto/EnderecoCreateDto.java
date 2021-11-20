package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Endereco;

public class EnderecoCreateDto {

	private String cep;
	private String numero;
	private String complemento;
	
	public EnderecoCreateDto( ) {

	}

	public EnderecoCreateDto(Endereco e) {
		this.cep = e.getCep();
		this.complemento = e.getComplemento();
		this.numero = e.getNumero();
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

}
