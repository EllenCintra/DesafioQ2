package br.com.ellen.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.ellen.desafio.model.Cargo;
import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.dto.FuncionarioCreateDto;
import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.model.mapper.FuncionarioMapper;
import br.com.ellen.desafio.repository.CargoRepository;
import br.com.ellen.desafio.repository.EmpresaRepository;
import br.com.ellen.desafio.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;
	private EmpresaRepository empresaRepository;
	private CargoRepository cargoRepository;

	public FuncionarioService(FuncionarioRepository f, EmpresaRepository e, CargoRepository c) {
		this.funcionarioRepository = f;
		this.empresaRepository = e;
		this.cargoRepository = c;
	}

	public FuncionarioDto insertFuncionario(@Valid FuncionarioCreateDto dto) {
		Funcionario funcionario = FuncionarioMapper.ofDto(dto);
		Empresa emp = empresaRepository.getById(dto.getEmpresa().getId());
		Cargo cargo = cargoRepository.findByName(dto.getCargo().getName());
		funcionario.setEmpresa(emp);
		funcionario.setCargo(cargo);
		Funcionario funSaved = funcionarioRepository.save(funcionario);
		return FuncionarioMapper.toDto(funSaved);
	}

	public FuncionarioDto getFuncionario(Long id, Long idF) {
		Funcionario funcionario = funcionarioRepository.getById(idF);
		Empresa emp = empresaRepository.getById(id);

		if (funcionario.getEmpresa() == emp) {
			return FuncionarioMapper.toDto(funcionario);
		} else
			return null;
	}
	
	public List<FuncionarioDto> listFuncionarios(Long id) {
		List<Funcionario> funcionarios = empresaRepository.getById(id).getFuncionarios();
		return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
	}

	public FuncionarioDto updateFuncionario(Long id, Long idF, @Valid FuncionarioDto dto) {
		Funcionario funcionario = funcionarioRepository.getById(idF);
		Empresa emp = empresaRepository.getById(id);
		Cargo cargo = cargoRepository.findByName(dto.getCargo().getName());

		if (funcionario.getEmpresa() == emp && cargo != null) {
			FuncionarioMapper.merge(funcionario, dto);
			funcionario.setCargo(cargo);
			
			return new FuncionarioDto(funcionarioRepository.save(funcionario));
		} else
			return null;
	}

	public void deleteFuncionario(Long id, Long idF) {
		Funcionario funcionario = funcionarioRepository.getById(idF);
		Empresa emp = empresaRepository.getById(id);

		if (funcionario.getEmpresa() == emp) {
			funcionarioRepository.deleteById(id);
			emp.getFuncionarios().remove(funcionario);
			empresaRepository.save(emp);
		}
	}

}
