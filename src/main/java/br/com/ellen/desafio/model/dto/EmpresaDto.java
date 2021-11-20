package br.com.ellen.desafio.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ellen.desafio.model.Empresa;

public class EmpresaDto {
	
	private String name;
	private String endereco;
	private String  telefone;
	private List<FuncionarioDto> funcionarios= new ArrayList<FuncionarioDto>();

	public EmpresaDto() {
		
	}
	public EmpresaDto(Empresa empresa) {
		this.name = empresa.getname();
		this.endereco = empresa.getEndereco();
		this.telefone = empresa.getTelefone();
		this.funcionarios = empresa.getFuncionarios().stream().map(FuncionarioDto::new).collect(Collectors.toList());
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
	public List<FuncionarioDto> getFuncionarios() {
		return funcionarios;
	}


}