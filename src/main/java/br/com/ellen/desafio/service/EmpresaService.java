package br.com.ellen.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.ellen.desafio.integrationViaCep.ViaCep;
import br.com.ellen.desafio.integrationViaCep.dto.ViaCepDto;
import br.com.ellen.desafio.model.Empresa;
import br.com.ellen.desafio.model.Endereco;
import br.com.ellen.desafio.model.Funcionario;
import br.com.ellen.desafio.model.dto.EmpresaConsultaDto;
import br.com.ellen.desafio.model.dto.EmpresaCreateUpdateDto;
import br.com.ellen.desafio.model.dto.EmpresaDto;
import br.com.ellen.desafio.model.dto.FuncionarioDto;
import br.com.ellen.desafio.model.mapper.EmpresaMapper;
import br.com.ellen.desafio.model.mapper.EnderecoMapper;
import br.com.ellen.desafio.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	private EmpresaRepository empresaRepository;
	private ViaCep viaCep;
	
	public EmpresaService(EmpresaRepository repository, ViaCep viacep) {
		this.empresaRepository = repository;
		this.viaCep = viacep;
	}

	public EmpresaDto insertEmpresa(@Valid EmpresaCreateUpdateDto empresaDto) {
		ViaCepDto vc = viaCep.getAddress(empresaDto.getEndereco().getCep());
		Endereco endereco = EnderecoMapper.ofDto(vc, empresaDto.getEndereco());
		Empresa emp = EmpresaMapper.ofDto(empresaDto);
		emp.setEndereco(endereco);
		
		boolean telefone = telefoneValido(emp.getTelefone());
		System.out.println(telefone);
		if (telefone==false) {
			emp.setTelefone(null);
		}
		System.out.println(emp.getTelefone());
		Empresa empSaved = empresaRepository.save(emp);
		return EmpresaMapper.toDto(empSaved);
	}
	
	public List<EmpresaConsultaDto> listEmpresas() {
		List<Empresa> empresas = empresaRepository.findAll();
		return empresas.stream().map(EmpresaConsultaDto::new).collect(Collectors.toList());
	}
	
	public EmpresaDto getEmpresa(Long id) {
		Empresa e = empresaRepository.getById(id);
		return EmpresaMapper.toDto(e);
	}

	public List<FuncionarioDto> listFuncionarios(Long id) {
		List<Funcionario> funcionarios = empresaRepository.getById(id).getFuncionarios();
		return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
	}
	
	public EmpresaDto updateEmpresa(Long id, @Valid EmpresaCreateUpdateDto empresaDto) {
		Empresa emp = empresaRepository.getById(id);
		
		ViaCepDto vc = viaCep.getAddress(empresaDto.getEndereco().getCep());
		Endereco endereco = EnderecoMapper.ofDto(vc, empresaDto.getEndereco());
		emp.setEndereco(endereco);
		
		EmpresaMapper.merge(emp, empresaDto);
		Empresa empSaved = empresaRepository.save(emp);
		return EmpresaMapper.toDto(empSaved);
	}

	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);			
	}

	//Para ser válido o telefone deve estar no formato "(11) 1111-1111" ou "(11) 11111-1111"
	public boolean telefoneValido(String telefone) {
		return telefone.matches("^\\((?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$");
	}
}
