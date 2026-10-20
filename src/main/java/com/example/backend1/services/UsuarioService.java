package com.example.backend1.services;


import com.example.backend1.models.Usuarios;
import com.example.backend1.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuarios guardar(Usuarios usuario){
        ///encriptar el texto plano
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return  usuarioRepository.save(usuario);
    }

    public List<Usuarios> obtenerTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios>obtenerPorId(long id){
        return  usuarioRepository.findById(id);
    }
}
