package com.epicode.airSabri.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epicode.airSabri.models.MyUser;

@Repository
public interface UtenteDAO extends JpaRepository<MyUser, Long> {

	public boolean existsById(Long id);

	Optional<MyUser> findByEmail(String email);

	Optional<MyUser> findByUserNameOrEmail(String username, String email);

	Optional<MyUser> findByUserName(String username);

	Boolean existsByUserName(String username);

	Boolean existsByEmail(String email);

	// SELECT * FROM postazioni p WHERE p.tipo = 'OPENSPACE' AND p.edificio_id in
	// (SELECT id from edifici where citta = 'Quasimodo lido')
	// @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND edificio
	// in(SELECT id FROM Edificio e WHERE e.citta = :citta)")
	// public List<Postazione> findPostazioneCitta(TipoPostazione tipo,String
	// citta);
}
