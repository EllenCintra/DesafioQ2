package br.com.ellen.desafio.model.dto;

import java.math.BigDecimal;

import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.mapper.CargoMapper;
import br.com.ellen.desafio.model.mapper.EmpresaMapper;

public class FuncionarioCreateDto {
	
	private EmpresaConsultaDto empresa;
	private String name;
	private CargoDto cargo;
	private BigDecimal salario;

	public FuncionarioCreateDto(Funcionario f) {
		this.name = f.getName();
		this.cargo = CargoMapper.toDto(f.getCargo());
		this.salario = f.getSalario();
		this.empresa = EmpresaMapper.toConsultaDto(f.getEmpresa());
	}
	
	public EmpresaConsultaDto getEmpresa() {
		return empresa;
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

	public FuncionarioCreateDto() {
		
	}
}