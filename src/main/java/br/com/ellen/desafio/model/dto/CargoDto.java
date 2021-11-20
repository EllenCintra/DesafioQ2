package br.com.ellen.desafio.model.dto;

import br.com.ellen.desafio.model.Cargo;

public class CargoDto {

	private String name;

	public CargoDto(Cargo cargo) {
		this.name = cargo.getName();
	}

	public CargoDto() {

	}

	public String getName() {
		return name;
	}
}
