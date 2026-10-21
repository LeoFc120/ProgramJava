package com.example.backend1.controllers;

import com.example.backend1.models.ProyectoResidencia;
import com.example.backend1.services.ProyectoResidenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@RequiredArgsConstructor
public class ProyectoResidenciaController {

    private final ProyectoResidenciaService proyectoResidenciaService;

    @PostMapping
    public ResponseEntity<ProyectoResidencia> crear(@RequestBody ProyectoResidencia proyecto) {
        ProyectoResidencia nuevoProyecto = proyectoResidenciaService.guardar(proyecto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoProyecto);
    }

    @GetMapping
    public List<ProyectoResidencia> listar() {
        return proyectoResidenciaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoResidencia> obtener(@PathVariable Integer id) {
        return proyectoResidenciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ProyectoResidencia actualizar(@PathVariable Integer id, @RequestBody ProyectoResidencia proyecto) {
        return proyectoResidenciaService.actualizar(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proyectoResidenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}