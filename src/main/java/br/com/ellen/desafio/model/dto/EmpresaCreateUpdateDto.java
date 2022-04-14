package br.com.ellen.desafio.model.dto;

public class EmpresaCreateUpdateDto {

	private String name;
	private EnderecoCreateDto endereco;
	private String  telefone;

	public EmpresaCreateUpdateDto() {
		
	}
	public String getName() {
		return name;
	}
	public EnderecoCreateDto getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
}
