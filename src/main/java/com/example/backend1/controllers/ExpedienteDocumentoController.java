package com.example.backend1.controllers;

import com.example.backend1.models.ExpedienteDocumento;
import com.example.backend1.services.ExpedienteDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expedientes")
@RequiredArgsConstructor
public class ExpedienteDocumentoController {

    private final ExpedienteDocumentoService expedienteDocumentoService;

    @PostMapping
    public ResponseEntity<ExpedienteDocumento> crear(@RequestBody ExpedienteDocumento documento) {
        ExpedienteDocumento nuevoDocumento = expedienteDocumentoService.guardar(documento);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoDocumento);
    }

    @GetMapping
    public List<ExpedienteDocumento> listar() {
        return expedienteDocumentoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpedienteDocumento> obtener(@PathVariable Integer id) {
        return expedienteDocumentoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ExpedienteDocumento actualizar(@PathVariable Integer id, @RequestBody ExpedienteDocumento documento) {
        return expedienteDocumentoService.actualizar(id, documento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        expedienteDocumentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}