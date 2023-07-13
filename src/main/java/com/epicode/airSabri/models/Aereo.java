package com.epicode.airSabri.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aereo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Aereo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aereoid")
	private Long aereoid;
	
	@Column(name = "nome_aereo")
	private String nomeAereo;
	
	@Column(name = "prezzo")
	private Double prezzo;
  
}
