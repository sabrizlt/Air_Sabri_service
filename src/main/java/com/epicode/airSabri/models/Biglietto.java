package com.epicode.airSabri.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.epicode.airSabri.enumerated.EBagagli;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "biglietti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Biglietto {
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private MyUser user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String dataAndata;
    @Column(nullable = false)
    private String dataRitorno;
    @Column(nullable = false)
    private String partenza;
    @Column(nullable = false)
    private String arrivo;
    @Enumerated(EnumType.STRING)
    private EBagagli bagagli;
    @Column(nullable = false)
    private String numeroBiglietto;
    @Column(nullable = false)
    private String numeroPosto;
}

