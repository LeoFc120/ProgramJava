package com.example.backend1.controllers;

import com.example.backend1.dto.AuthResponse;
import com.example.backend1.dto.LoginRequest;
import com.example.backend1.models.Usuarios;
import com.example.backend1.repositories.UsuarioRepository;
import com.example.backend1.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 1. Buscamos si existe un usuario con ese correo
        Usuarios usuario = usuarioRepository.findByCorreo(request.getCorreo()).orElse(null);

        // 2. Si no existe, o la contraseña encriptada NO coincide con la que nos mandan
        if (usuario == null || !passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

        // 3. Si todo está correcto, generamos el JWT
        String token = jwtService.generarToken(usuario);

        // 4. Retornamos el token al cliente (Bruno / Frontend)
        return ResponseEntity.ok(new AuthResponse(token));
    }
}