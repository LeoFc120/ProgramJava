package com.example.backend1.controllers;

import com.example.backend1.models.Usuarios;
import com.example.backend1.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    // Spring inyecta la instancia aquí
    private final UsuarioService usuarioService;

    // crear usuario
    @PostMapping
    public ResponseEntity<Usuarios> crear(@RequestBody Usuarios usuario) {

        // Usa la variable de instancia en minúsculas (usuarioService), no el nombre de la Clase con mayúscula
        Usuarios nuevoUsuario = usuarioService.guardar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoUsuario);
    }
    @GetMapping
    public List<Usuarios> listar() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Usuarios actualizar(@PathVariable Long id, @RequestBody Usuarios usuario) {
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
