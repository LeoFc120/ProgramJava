package com.example.backend1.controllers;

import com.example.backend1.models.AsesorAcademico;
import com.example.backend1.services.AsesorAcademicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asesores")
@RequiredArgsConstructor
public class AsesorAcademicoController {

    private final AsesorAcademicoService asesorAcademicoService;

    @PostMapping
    public ResponseEntity<AsesorAcademico> crear(@RequestBody AsesorAcademico asesor) {
        AsesorAcademico nuevoAsesor = asesorAcademicoService.guardar(asesor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoAsesor);
    }

    @GetMapping
    public List<AsesorAcademico> listar() {
        return asesorAcademicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsesorAcademico> obtener(@PathVariable Integer id) {
        return asesorAcademicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public AsesorAcademico actualizar(@PathVariable Integer id, @RequestBody AsesorAcademico asesor) {
        return asesorAcademicoService.actualizar(id, asesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asesorAcademicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}