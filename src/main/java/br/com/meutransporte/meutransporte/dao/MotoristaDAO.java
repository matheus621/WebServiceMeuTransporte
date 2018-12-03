package br.com.meutransporte.meutransporte.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meutransporte.meutransporte.model.Motorista;

@Repository
public interface MotoristaDAO extends JpaRepository<Motorista, Long> {

	Optional<Motorista> findByNome(String nome);
}