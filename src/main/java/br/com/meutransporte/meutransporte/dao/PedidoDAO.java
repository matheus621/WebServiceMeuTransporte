package br.com.meutransporte.meutransporte.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meutransporte.meutransporte.model.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long> {

	Optional<Pedido> findByNome(String nome);
}