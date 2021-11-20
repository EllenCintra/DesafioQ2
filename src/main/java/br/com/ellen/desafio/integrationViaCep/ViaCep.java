package br.com.ellen.desafio.integrationViaCep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ellen.desafio.integrationViaCep.dto.ViaCepDto;

@FeignClient(value = "viaCepClient", url = "http://viacep.com.br")
public interface ViaCep {

	@GetMapping(value = "/ws/{zipCode}/json/", consumes = { "application/json" })
	@ResponseBody
	public ViaCepDto getAddress(@PathVariable("zipCode") String zipCode);

}
