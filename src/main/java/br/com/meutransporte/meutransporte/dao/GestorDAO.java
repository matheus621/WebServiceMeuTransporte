package br.com.meutransporte.meutransporte.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meutransporte.meutransporte.model.Gestor;

@Repository
public interface GestorDAO extends JpaRepository<Gestor, Long> {

	Optional<Gestor> findByNome(String nome);
}