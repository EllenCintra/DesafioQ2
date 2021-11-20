package br.com.ellen.desafio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import br.com.ellen.desafio.model.dto.EmpresaDto;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Column(nullable = false, length = 200)
	private String name;
	//@ManyToOne
	private String endereco;
	private String telefone;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public String getname() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public EmpresaDto toDto() {
		return new EmpresaDto(this);
	}
	public long getId() {
		return this.id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
