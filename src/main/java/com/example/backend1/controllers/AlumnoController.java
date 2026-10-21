package com.example.backend1.controllers;

import com.example.backend1.models.Alumno;
import com.example.backend1.services.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<Alumno> crear(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.guardar(alumno);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoAlumno);
    }

    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtener(@PathVariable String id) {
        return alumnoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable String id, @RequestBody Alumno alumno) {
        return alumnoService.actualizar(id, alumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}