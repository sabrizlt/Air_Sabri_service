package com.epicode.airSabri.security.service;

import com.epicode.airSabri.security.payload.LoginDto;
import com.epicode.airSabri.security.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
