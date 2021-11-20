package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.mapper.EnderecoMapper;

public class EmpresaCreateUpdateDto {

	private String name;
	private EnderecoCreateDto endereco;
	private String  telefone;

	public EmpresaCreateUpdateDto() {
		
	}
	public EmpresaCreateUpdateDto(Empresa empresa) {
		this.name = empresa.getname();
		this.endereco = EnderecoMapper.toCreateDto(empresa.getEndereco());
		this.telefone = empresa.getTelefone();
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
