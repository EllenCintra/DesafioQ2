package br.com.ellen.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Telefone {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull @NotEmpty
	private String numero;
	@ManyToOne @NotNull @NotEmpty
	private Empresa empresa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String name) {
		this.numero = name;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa emp) {
		this.empresa = emp;
	}
}
