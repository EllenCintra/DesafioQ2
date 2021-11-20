package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Empresa;

public class EmpresaCreateUpdateDto {

	private String name;
	private String endereco;
	private String  telefone;

	public EmpresaCreateUpdateDto() {
		
	}
	public EmpresaCreateUpdateDto(Empresa empresa) {
		this.name = empresa.getname();
		this.endereco = empresa.getEndereco();
		this.telefone = empresa.getTelefone();
	}
	public String getName() {
		return name;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
}
