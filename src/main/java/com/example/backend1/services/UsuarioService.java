package com.example.backend1.services;

import com.example.backend1.models.Usuarios;
import com.example.backend1.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuarios guardar(Usuarios usuario) {
        // Encriptar la contraseña solo si viene informada
        if (usuario.getPassword() != null && !usuario.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuarios> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuarios actualizar(Long id, Usuarios datos) {
        Usuarios existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        existente.setCorreo(datos.getCorreo());
        existente.setRol(datos.getRol());
        existente.setActivo(datos.getActivo());

        if (datos.getPassword() != null && !datos.getPassword().isBlank()) {
            existente.setPassword(passwordEncoder.encode(datos.getPassword()));
        }

        return usuarioRepository.save(existente);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}