package br.com.ellen.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ellen.desafio.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Cargo findByName(String name);
}
