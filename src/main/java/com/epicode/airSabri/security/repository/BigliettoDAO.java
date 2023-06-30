package com.epicode.airSabri.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.airSabri.models.Biglietto;

@Repository
public interface BigliettoDAO extends JpaRepository<Biglietto, Long> {
}
