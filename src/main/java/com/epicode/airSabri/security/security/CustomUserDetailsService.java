package com.epicode.airSabri.security.security;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epicode.airSabri.models.MyUser;
import com.epicode.airSabri.security.repository.UtenteDAO;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UtenteDAO userRepository;

    public CustomUserDetailsService(UtenteDAO userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "MyUser not found with username or email: " + usernameOrEmail));

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                authorities);
    }
}
