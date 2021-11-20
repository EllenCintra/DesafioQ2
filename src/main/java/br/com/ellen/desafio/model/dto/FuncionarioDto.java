package br.com.ellen.desafio.model.dto;

import java.math.BigDecimal;

import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.mapper.CargoMapper;

public class FuncionarioDto {

	private long id;
	private String name;
	private CargoDto cargo;
	private BigDecimal salario;

	public FuncionarioDto(Funcionario f) {
		this.id = f.getId();
		this.name = f.getName();
		this.cargo = CargoMapper.toDto(f.getCargo());
		this.salario = f.getSalario();
	}

	public String getName() {
		return name;
	}

	public CargoDto getCargo() {
		return cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public FuncionarioDto() {
		
	}

	public long getId() {
		return id;
	}
}