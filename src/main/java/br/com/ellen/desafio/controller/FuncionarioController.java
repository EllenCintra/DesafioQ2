package br.com.ellen.desafio.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ellen.desafio.model.dto.FuncionarioCreateDto;
import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.service.FuncionarioService;

@RestController
@RequestMapping("empresa/{id}/funcionario")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService service) {
		this.funcionarioService = service;
	}

	@PostMapping
	public ResponseEntity<FuncionarioDto> insertFuncionario (@PathVariable Long id, @RequestBody @Valid FuncionarioCreateDto funcionarioDto) {
		return new ResponseEntity<FuncionarioDto>(funcionarioService.insertFuncionario(id, funcionarioDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{idF}")
	public FuncionarioDto funcionario(@PathVariable Long id, @PathVariable Long idF) {
		return funcionarioService.getFuncionario(id, idF);		
	}
	
	@PutMapping("/{idF}")
	@Transactional
	public ResponseEntity<FuncionarioDto> updateFuncionario(@PathVariable Long id, @PathVariable Long idF, @RequestBody @Valid FuncionarioDto funcionarioDto) {
		return new ResponseEntity<FuncionarioDto>(funcionarioService.updateFuncionario(id, idF, funcionarioDto), HttpStatus.OK);
	}

	@DeleteMapping("/{idF}")
	public ResponseEntity<?> deleteFuncionario(@PathVariable Long id, @PathVariable Long idF) {
		funcionarioService.deleteFuncionario(id, idF);
		return ResponseEntity.ok().build();
	}
}
