package br.com.ellen.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ellen.desafio.model.dto.EmpresaConsultaDto;
import br.com.ellen.desafio.model.dto.EmpresaCreateUpdateDto;
import br.com.ellen.desafio.model.dto.EmpresaDto;
import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("http://localhost:4200")
public class EmpresaController {
	
	private EmpresaService empresaService;
	
	public EmpresaController(EmpresaService service) {
		this.empresaService = service;
	}

	@PostMapping
	public ResponseEntity<EmpresaDto> insertEmpresa (@RequestBody @Valid EmpresaCreateUpdateDto empresaDto) {
		return new ResponseEntity<EmpresaDto>(empresaService.insertEmpresa(empresaDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EmpresaConsultaDto> listEmpresas() {
		return empresaService.listEmpresas();		
	}
	
	@GetMapping("/{id}/funcionarios")
	public List<FuncionarioDto> getFuncionarioByEmpresa(@PathVariable Long id) {
		return empresaService.listFuncionarios(id);		
	}
	
	@GetMapping("/{id}")
	public EmpresaDto getEmpresa(@PathVariable Long id) {
		return empresaService.getEmpresa(id);		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmpresaDto> updateEmpresa(@PathVariable Long id, @RequestBody @Valid EmpresaCreateUpdateDto empresaDto) {
		return new ResponseEntity<EmpresaDto>(empresaService.updateEmpresa(id, empresaDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
		empresaService.deleteEmpresa(id);
		return ResponseEntity.ok().build();
	}

}
