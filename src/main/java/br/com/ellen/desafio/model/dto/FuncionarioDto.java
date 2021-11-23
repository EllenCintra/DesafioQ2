package br.com.ellen.desafio.model.dto;

import java.math.BigDecimal;

import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.mapper.CargoMapper;
import br.com.ellen.desafio.model.mapper.EmpresaMapper;

public class FuncionarioDto {

	private long id;
	private String name;
	private CargoDto cargo;
	private BigDecimal salario;
	private EmpresaConsultaDto empresa;
	
	public FuncionarioDto(Funcionario f) {
		this.id = f.getId();
		this.name = f.getName();
		this.cargo = CargoMapper.toDto(f.getCargo());
		this.salario = f.getSalario();
		this.empresa = EmpresaMapper.toConsultaDto(f.getEmpresa());
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

	public EmpresaConsultaDto getEmpresa() {
		return empresa;
	}
}