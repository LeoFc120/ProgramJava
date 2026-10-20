package com.example.backend1.repositories;

import com.example.backend1.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByCorreo(String correo) ;

}
