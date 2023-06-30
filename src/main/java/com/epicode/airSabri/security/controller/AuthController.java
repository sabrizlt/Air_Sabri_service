package com.epicode.airSabri.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.airSabri.models.MyUser;
import com.epicode.airSabri.security.payload.JWTAuthResponse;
import com.epicode.airSabri.security.payload.LoginDto;
import com.epicode.airSabri.security.payload.RegisterDto;
import com.epicode.airSabri.security.repository.UtenteDAO;
import com.epicode.airSabri.security.service.AuthService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    private @Autowired UtenteDAO utenteDAO;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = { "/login", "/signin" })
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {

        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUserName());
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = { "/register", "/signup" })
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<MyUser> getAllUsers() {
        return utenteDAO.findAll();
    }
}
