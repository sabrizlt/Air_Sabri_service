package com.epicode.airSabri.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.airSabri.security.payload.UtenteDTO;
import com.epicode.airSabri.services.UtenteService;

import jakarta.annotation.security.PermitAll;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UserController {

	@Autowired
	UtenteService utenteService;

	@GetMapping
	@PermitAll
	public ResponseEntity<?> findByUsername(@RequestParam String username) {

		return ResponseEntity.ok(utenteService.findByUsername(username));
	}

	@GetMapping("/{id}")
	@PermitAll
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(utenteService.findUserById(id));
	}

	@PutMapping("/{id}")
	@PermitAll
	public ResponseEntity<?> modifyUser(@PathVariable Long id, @RequestBody UtenteDTO user) {
		return ResponseEntity.ok(utenteService.updateUtente(id, user));
	}
}
