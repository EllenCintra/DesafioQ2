package br.com.ellen.desafio.model.mapper;

import br.com.ellen.desafio.integrationViaCep.dto.ViaCepDto;
import br.com.ellen.desafio.model.Endereco;
import br.com.ellen.desafio.model.dto.EnderecoCreateDto;
import br.com.ellen.desafio.model.dto.EnderecoDto;

public class EnderecoMapper {

	public static EnderecoDto toDto (Endereco endereco) {
		return new EnderecoDto(endereco);
	}
	
	public static Endereco ofDto (ViaCepDto vcDto, EnderecoCreateDto enderecoDto) {
		Endereco e = new Endereco();
		e.setCep(vcDto.getCep());
		e.setLogradouro(vcDto.getLogradouro());
		e.setBairro(vcDto.getBairro());
		e.setLocalidade(vcDto.getLocalidade());
		e.setUf(vcDto.getUf());
		e.setNumero(enderecoDto.getNumero());
		e.setComplemento(enderecoDto.getComplemento());
		
		return e;
	}

	public static EnderecoCreateDto toCreateDto (Endereco endereco) {
		return new EnderecoCreateDto(endereco);
	}

}
