package com.thefoods.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.thefoods.backend.service.*;
import com.thefoods.backend.repository.*;
import com.thefoods.backend.dto.*;
import com.thefoods.backend.entity.*;
import com.thefoods.backend.security.JwtUtil;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}