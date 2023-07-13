package com.epicode.airSabri.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.airSabri.models.Aereo;

@Repository
public interface AereoDAO extends JpaRepository<Aereo, Long> {

}
