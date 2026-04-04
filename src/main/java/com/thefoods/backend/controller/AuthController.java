package com.thefoods.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.thefoods.backend.service.*;
import com.thefoods.backend.dto.*;
import com.thefoods.backend.entity.*;
import java.util.*;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}