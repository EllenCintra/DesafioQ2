package br.com.ellen.desafio.model.mapper;

import br.com.ellen.desafio.model.Cargo;
import br.com.ellen.desafio.model.dto.CargoDto;

public class CargoMapper {
	
	public static void merge(Cargo result, CargoDto from) {
        result.setName(from.getName());
    }
	
	public static Cargo ofDto (CargoDto dto) {
		return new Cargo(dto.getName());
	}

	public static CargoDto toDto (Cargo cargo) {
		return new CargoDto(cargo);
	}

}

