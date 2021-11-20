package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Endereco;

public class EnderecoDto {
		
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String numero;
	private String complemento;

	public EnderecoDto(Endereco e) {
		this.cep = e.getCep();
		this.logradouro = e.getLogradouro();
		this.bairro = e.getBairro();
		this.localidade = e.getLocalidade();
		this.uf = e.getUf();
		this.numero = e.getNumero();
		this.complemento = e.getComplemento();
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
