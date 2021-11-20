package br.com.ellen.desafio.model.mapper;

import javax.validation.Valid;

import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.dto.FuncionarioCreateDto;
import br.com.ellen.desafio.model.dto.FuncionarioDto;

public class FuncionarioMapper {
	
	public static void merge(Funcionario result, FuncionarioDto dto) {
        result.setName(dto.getName());
        result.setSalario(dto.getSalario());
    }
	
	public static Funcionario ofDto (@Valid FuncionarioCreateDto dto) {
		Funcionario fun = new Funcionario();
		fun.setName(dto.getName());
		fun.setSalario(dto.getSalario());
		return fun;
	}

	public static FuncionarioDto toDto (Funcionario fun) {
		return new FuncionarioDto(fun);
	}

}
