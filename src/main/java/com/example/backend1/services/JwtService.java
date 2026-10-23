package com.example.backend1.services;

import com.example.backend1.models.Usuarios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // Genera una llave secreta muy segura automáticamente
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generarToken(Usuarios usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreo()) // A quién le pertenece el token
                .claim("rol", usuario.getRol().name()) // Guardamos su rol
                .claim("idUsuario", usuario.getIdUsuario()) // Guardamos su ID
                .setIssuedAt(new Date()) // Fecha de creación
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expira en 10 horas
                .signWith(SECRET_KEY) // Firmado criptográficamente
                .compact();
    }
}