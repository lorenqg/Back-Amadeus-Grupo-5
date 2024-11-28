package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.config.auth.JwtTokenProvider;
import com.adventureAPI.AdventureAPI.dto.AuthResponse;
import com.adventureAPI.AdventureAPI.dto.UserDTO;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    public AuthController(JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDto) {
        if (isValidUser(userDto)) {
            // Generar el token
            String token = jwtTokenProvider.generateToken(userDto.getName(), userDto.getEmail());
            // Obtener la fecha de expiración
            Date expiration = jwtTokenProvider.getExpirationDate(token);
            return ResponseEntity.ok().body(new AuthResponse(token, expiration));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    private boolean isValidUser(UserDTO userDto) {
        // Aquí puedes validar el nombre y email, por ejemplo, contra una base de datos.
        User user = userRepository.findByEmailAndName(userDto.getEmail(), userDto.getName());
        return user != null;
    }
}

