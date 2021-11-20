package br.com.ellen.desafio.model.mapper;

import javax.validation.Valid;

import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.dto.EmpresaCreateUpdateDto;
import br.com.ellen.desafio.model.dto.EmpresaDto;

public class EmpresaMapper {
	public static void merge(Empresa result, @Valid EmpresaCreateUpdateDto dto) {
		result.setName(dto.getName());
		result.setEndereco(dto.getEndereco());
		result.setTelefone(dto.getTelefone());
		//result.setFuncionarios(from.getFuncionarios());
	}

	public static Empresa ofDto(EmpresaCreateUpdateDto dto) {
		Empresa emp = new Empresa();
		emp.setName(dto.getName());
		emp.setEndereco(dto.getEndereco());
		emp.setTelefone(dto.getTelefone());
		return emp;
	}

	public static EmpresaDto toDto(Empresa empresa) {
		return new EmpresaDto(empresa);
	}

}
