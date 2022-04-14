package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Empresa;

public class EmpresaConsultaDto {

	private long id;
	private String name;
	
	public EmpresaConsultaDto() {}
	
	public EmpresaConsultaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.name = empresa.getname();
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
