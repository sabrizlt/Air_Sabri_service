package com.epicode.airSabri.security.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epicode.airSabri.enumerated.ERole;
import com.epicode.airSabri.models.Role;
import com.epicode.airSabri.models.MyUser;
import com.epicode.airSabri.security.payload.LoginDto;
import com.epicode.airSabri.security.payload.RegisterDto;
import com.epicode.airSabri.security.repository.RoleDAO;
import com.epicode.airSabri.security.repository.UtenteDAO;
import com.epicode.airSabri.security.security.JwtTokenProvider;



@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UtenteDAO userRepository;
    private RoleDAO roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
            UtenteDAO userRepository,
            RoleDAO roleRepository,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUserName(), loginDto.getPassword()));
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if (userRepository.existsByUserName(registerDto.getUserName())) {
            // throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already
            // exists!.");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            // throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email is already
            // exists!.");
        }

        MyUser user = new MyUser();
        user.setNome(registerDto.getNome());
        user.setCognome(registerDto.getCognome());
        user.setUserName(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();

        if (registerDto.getRoles() != null) {
            registerDto.getRoles().forEach(role -> {
                Role userRole = roleRepository.findByRoleName(getRole(role)).get();
                roles.add(userRole);
            });
        } else {
            Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
            roles.add(userRole);
        }

        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);

        return "MyUser registered successfully!.";
    }

    public ERole getRole(String role) {
        if (role.equals("ADMIN")) {
            return ERole.ROLE_ADMIN;
        }

        else
            return ERole.ROLE_USER;
    }

}
