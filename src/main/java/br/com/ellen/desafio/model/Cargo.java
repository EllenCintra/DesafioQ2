package br.com.ellen.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cargo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull @NotEmpty
	private String name;
	
	public Cargo(String name) {
		this.name = name;	
	}
	public Cargo() {
			
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
