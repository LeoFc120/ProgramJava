package com.example.backend1.services;

import com.example.backend1.models.Empresa;
import com.example.backend1.repositories.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> obtenerTodos() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obtenerPorId(Integer id) {
        return empresaRepository.findById(id);
    }

    public Empresa actualizar(Integer id, Empresa datos) { // Cambiado a Integer
        Empresa existente = empresaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa no encontrada"));

        // TODO: Cambia estos set
        // existente.setNombre(datos.getNombre());

        return empresaRepository.save(existente);
    }

    public void eliminar(Integer id) { // Cambiado a Integer
        empresaRepository.deleteById(id);
    }
}