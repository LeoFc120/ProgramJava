package com.example.backend1.controllers;

import com.example.backend1.models.Empresa;
import com.example.backend1.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> crear(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.guardar(empresa);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaEmpresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtener(@PathVariable Integer id) {
        return empresaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Empresa actualizar(@PathVariable Integer id, @RequestBody Empresa empresa) {
        return empresaService.actualizar(id, empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        empresaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}