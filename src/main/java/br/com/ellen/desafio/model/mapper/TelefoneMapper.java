package br.com.ellen.desafio.model.mapper;

import br.com.ellen.desafio.model.Telefone;
import br.com.ellen.desafio.model.dto.TelefoneDto;

public class TelefoneMapper {

	public static void merge(Telefone result, TelefoneDto from) {
        result.setNumero(from.getNumero());
    }
	
	public static Telefone ofDto (TelefoneDto dto) {
		Telefone tel = new Telefone();
		tel.setNumero(dto.getNumero());
		return tel;
	}

	public static TelefoneDto toDto (Telefone tel) {
		return new TelefoneDto(tel);
	}
}
