package com.epicode.airSabri.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.airSabri.models.Biglietto;
import com.epicode.airSabri.models.MyUser;


@Repository
public interface BigliettoDAO extends JpaRepository<Biglietto, Long> {
	public List<Biglietto> findByUser(MyUser username);
}
