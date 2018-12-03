package br.com.meutransporte.meutransporte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "MOTORISTA")
public class Motorista {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String posicao;
	
}


