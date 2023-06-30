package com.epicode.airSabri.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.airSabri.enumerated.ERole;
import com.epicode.airSabri.models.Role;


public interface RoleDAO extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(ERole roleName);
}
