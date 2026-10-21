package com.example.backend1.controllers;

import com.example.backend1.models.Postulacion;
import com.example.backend1.services.PostulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postulaciones")
@RequiredArgsConstructor
public class PostulacionController {

    private final PostulacionService postulacionService;

    @PostMapping
    public ResponseEntity<Postulacion> crear(@RequestBody Postulacion postulacion) {
        Postulacion nuevaPostulacion = postulacionService.guardar(postulacion);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaPostulacion);
    }

    @GetMapping
    public List<Postulacion> listar() {
        return postulacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> obtener(@PathVariable Long id) {
        return postulacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Postulacion actualizar(@PathVariable Long id, @RequestBody Postulacion postulacion) {
        return postulacionService.actualizar(id, postulacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        postulacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}